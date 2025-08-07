package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.atendente.controller;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.AtualizarAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.CadastrarAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.DeletarAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.FiltrarAtendentePorUuid;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.CampoInvalidoExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.autentificador.AutenticarAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.token.GerarToken;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.atendente.dto.AtendenteEntradaDTO;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.atendente.dto.AtendenteLoginDTO;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.atendente.dto.AtendenteRetornoDTO;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.atendente.dto.RetornoDeLoginDTO;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.atendente.mapper.AtendenteMapper;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.handler.dto.ErroCustomizadoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/atendente")
@Tag(name = "Atendente", description = "Controller para atendente")
public class AtendenteController {

    private final CadastrarAtendente cadastrarAtendente;
    private final FiltrarAtendentePorUuid filtrarAtendentePorUuid;
    private final AtualizarAtendente atualizarAtendente;
    private final DeletarAtendente deletarAtendente;
    private final GerarToken gerarToken;
    private final AutenticarAtendente autenticarAtendente;

    public AtendenteController(CadastrarAtendente cadastrarAtendente, FiltrarAtendentePorUuid filtrarAtendentePorUuid,
                               AtualizarAtendente atualizarAtendente, DeletarAtendente deletarAtendente,
                               GerarToken gerarToken, AutenticarAtendente autenticarAtendente) {
        this.cadastrarAtendente = cadastrarAtendente;
        this.filtrarAtendentePorUuid = filtrarAtendentePorUuid;
        this.atualizarAtendente = atualizarAtendente;
        this.deletarAtendente = deletarAtendente;
        this.gerarToken = gerarToken;
        this.autenticarAtendente = autenticarAtendente;
    }

    @Operation(description = "Realiza login", summary = "Login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso", content = @Content(schema = @Schema(implementation = RetornoDeLoginDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden")})
    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<RetornoDeLoginDTO> login(@RequestBody @Valid AtendenteLoginDTO dto) {
        Atendente dominio = autenticarAtendente.autenticar(dto.email(), dto.senha());
        String token = gerarToken.gerarToken(dominio);
        return ResponseEntity.ok().body(new RetornoDeLoginDTO(token));
    }

    @Operation(description = "Cadastra novo atendente", summary = "Cadastrar atendente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Atendente cadastrado com sucesso", content = @Content(schema = @Schema(implementation = AtendenteRetornoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "409", description = "Conflict", content = @Content(schema = @Schema(implementation = CampoInvalidoExcecao.class))),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class)))})
    @PostMapping(produces = "application/json")
    public ResponseEntity<AtendenteRetornoDTO> cadastrarAtendente(@RequestBody AtendenteEntradaDTO dto) {
        Atendente dominio = cadastrarAtendente.cadastrarNovoAtendente(AtendenteMapper.paraDominio(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(dominio.getUuid())
                .toUri();
        return ResponseEntity.created(uri).body(AtendenteMapper.paraDto(dominio));
    }

    @Operation(description = "Retorna um atendente filtrado pelo uuid", summary = "Retorna atendente por uuid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atendente retornado com sucesso", content = @Content(schema = @Schema(implementation = AtendenteRetornoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class)))})
    @GetMapping(value = "/{uuid}", produces = "application/json")
    public ResponseEntity<AtendenteRetornoDTO> filtrarPorUuid(@PathVariable UUID uuid) {
        Atendente dominio = filtrarAtendentePorUuid.findByUuid(uuid);
        return ResponseEntity.ok().body(AtendenteMapper.paraDto(dominio));
    }

    @Operation(description = "Atualiza os dados do atendente", summary = "Atualiza atendente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atendente atualizado com sucesso", content = @Content(schema = @Schema(implementation = AtendenteRetornoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class)))})
    @PutMapping(value = "/{uuid}", produces = "application/json")
    public ResponseEntity<AtendenteRetornoDTO> atualizarAtendente(@PathVariable UUID uuid,
                                                                  @RequestBody AtendenteEntradaDTO dto) {
        Atendente dominio = atualizarAtendente.atualizarDadosAtendente(uuid, AtendenteMapper.paraDominio(dto));
        return ResponseEntity.ok().body(AtendenteMapper.paraDto(dominio));
    }

    @Operation(description = "Deleta atendente filtrado por uuid", summary = "Deleta atendente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Exclusão do atendente realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class)))})
    @DeleteMapping(value = "/{uuid}", produces = "aplication/json")
    public ResponseEntity<Void> deletarAtendente(@PathVariable UUID uuid) {
        deletarAtendente.deletarAtendentePorUuid(uuid);
        return ResponseEntity.noContent().build();
    }
}
