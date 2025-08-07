package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.medico.controller;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.CampoInvalidoExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases.*;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Especialidade;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.handler.dto.ErroCustomizadoDTO;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.medico.dto.MedicoDTO;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.medico.mapper.MedicoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/medico")
@Tag(name = "Médico", description = "Controller para médico")
public class MedicoController {

    private final AtualizarMedico atualizarMedico;
    private final CadastrarMedico cadastrarMedico;
    private final DeletarMedico deletarMedico;
    private final DesativarCadastroMedico desativarCadastroMedico;
    private final FiltrarMedicosPorEspecialidade filtrarMedicosPorEspecialidade;
    private final FiltrarMedicosPorUuid filtrarMedicosPorUuid;
    private final ListarMedicos listarMedicos;
    private final ReativarCadastroMedico reativarCadastroMedico;

    public MedicoController(AtualizarMedico atualizarMedico, CadastrarMedico cadastrarMedico,
                            DeletarMedico deletarMedico,
                            DesativarCadastroMedico desativarCadastroMedico,
                            FiltrarMedicosPorEspecialidade filtrarMedicosPorEspecialidade,
                            FiltrarMedicosPorUuid filtrarMedicosPorUuid, ListarMedicos listarMedicos,
                            ReativarCadastroMedico reativarCadastroMedico) {
        this.atualizarMedico = atualizarMedico;
        this.cadastrarMedico = cadastrarMedico;
        this.deletarMedico = deletarMedico;
        this.desativarCadastroMedico = desativarCadastroMedico;
        this.filtrarMedicosPorEspecialidade = filtrarMedicosPorEspecialidade;
        this.filtrarMedicosPorUuid = filtrarMedicosPorUuid;
        this.listarMedicos = listarMedicos;
        this.reativarCadastroMedico = reativarCadastroMedico;
    }

    @Operation(description = "Cadastra novo médico", summary = "Cadastrar médico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Médico cadastrado com sucesso", content = @Content(schema = @Schema(implementation = MedicoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "409", description = "Conflict", content = @Content(schema = @Schema(implementation = CampoInvalidoExcecao.class))),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class)))})
    @PostMapping(produces = "application/json")
    public ResponseEntity<MedicoDTO> cadastrarMedico(@RequestBody MedicoDTO dto) {
        Medico dominio = cadastrarMedico.cadastrarNovoMedico(MedicoMapper.paraDominio(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(dominio.getUuid())
                .toUri();
        return ResponseEntity.created(uri).body(MedicoMapper.paraDto(dominio));
    }

    @Operation(description = "Retorna um médico filtrado pelo uuid", summary = "Retorna médico por uuid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Médico retornado com sucesso", content = @Content(schema = @Schema(implementation = MedicoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class)))})
    @GetMapping(value = "/{uuid}", produces = "application/json")
    public ResponseEntity<MedicoDTO> filtrarMedicoPorUuid(@PathVariable UUID uuid) {
        Medico dominio = filtrarMedicosPorUuid.findByUuid(uuid);
        return ResponseEntity.ok().body(MedicoMapper.paraDto(dominio));
    }

    @Operation(description = "Retorna lista de médicos filtrados pela especialidade", summary = "Retorna lista de médicos filtrado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicos retornados com sucesso"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden")})
    @GetMapping(value = "/porEspecialidade/{especialidade}", produces = "application/json")
    public ResponseEntity<List<MedicoDTO>> filtrarMedicoPorEspecialidade(@PathVariable Especialidade especialidade) {
        List<Medico> dominio = filtrarMedicosPorEspecialidade.listarMedicosPorEspecialidade(especialidade);
        return ResponseEntity.ok().body(dominio.stream().map(MedicoMapper::paraDto).toList());
    }

    @Operation(description = "Retorna lista de todos médicos", summary = "Retorna todos médicos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicos retornados com sucesso"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden")})
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<MedicoDTO>> listarTodosMedicos() {
        List<Medico> dominio = listarMedicos.listarTodosMedicos();
        return ResponseEntity.ok().body(dominio.stream().map(MedicoMapper::paraDto).toList());
    }

    @Operation(description = "Atualiza os dados do médico", summary = "Atualiza médico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Médico atualizado com sucesso", content = @Content(schema = @Schema(implementation = MedicoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class)))})
    @PutMapping(value = "/{uuid}", produces = "application/json")
    public ResponseEntity<MedicoDTO> atualizarMedico(@PathVariable UUID uuid, @RequestBody MedicoDTO dto) {
        Medico dominio = atualizarMedico.atualizarDadosMedico(uuid, MedicoMapper.paraDominio(dto));
        return ResponseEntity.ok().body(MedicoMapper.paraDto(dominio));
    }

    @Operation(description = "Atualiza médico mudando atributo 'ativo' para false", summary = "Desativar médico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cadastro médico desativado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class)))})
    @PutMapping(value = "/desativar/{uuid}", produces = "application/json")
    public ResponseEntity<Void> desativarCadastroMedico(@PathVariable UUID uuid) {
        desativarCadastroMedico.desativarMedico(uuid);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Atualiza médico mudando atributo 'ativo' para true", summary = "Reativar médico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cadastro médico reativado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class)))})
    @PutMapping(value = "/reativar/{uuid}", produces = "application/json")
    public ResponseEntity<Void> reativarCadastroMedico(@PathVariable UUID uuid) {
        reativarCadastroMedico.reativarMedico(uuid);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Deleta médico filtrado por uuid", summary = "Deleta médico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Exclusão do médico realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class)))})
    @DeleteMapping(value = "/{uuid}", produces = "application/json")
    public ResponseEntity<Void> deletarMedico(@PathVariable UUID uuid) {
        deletarMedico.deletarMedicoPorUuid(uuid);
        return ResponseEntity.noContent().build();
    }
}
