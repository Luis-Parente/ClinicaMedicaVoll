package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.paciente.controller;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.CampoInvalidoExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases.AtualizarPaciente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases.CadastrarPaciente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases.DeletarPaciente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases.FiltrarPacientePorUuid;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.paciente.Paciente;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.handler.dto.ErroCustomizadoDTO;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.paciente.dto.PacienteDTO;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.paciente.mapper.PacienteMapper;
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
import java.util.UUID;

@RestController
@RequestMapping(value = "/paciente")
@Tag(name = "Paciente", description = "Controller para paciente")
public class PacienteController {

    private final AtualizarPaciente atualizarPaciente;
    private final CadastrarPaciente cadastrarPaciente;
    private final DeletarPaciente deletarPaciente;
    private final FiltrarPacientePorUuid filtrarPacientePorUuid;

    public PacienteController(AtualizarPaciente atualizarPaciente, CadastrarPaciente cadastrarPaciente,
                              DeletarPaciente deletarPaciente, FiltrarPacientePorUuid filtrarPacientePorUuid) {
        this.atualizarPaciente = atualizarPaciente;
        this.cadastrarPaciente = cadastrarPaciente;
        this.deletarPaciente = deletarPaciente;
        this.filtrarPacientePorUuid = filtrarPacientePorUuid;
    }

    @Operation(description = "Cadastra novo paciente", summary = "Cadastrar paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Paciente cadastrado com sucesso", content = @Content(schema = @Schema(implementation = PacienteDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "409", description = "Conflict", content = @Content(schema = @Schema(implementation = CampoInvalidoExcecao.class))),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class)))})
    @PostMapping(produces = "application/json")
    public ResponseEntity<PacienteDTO> cadastrarPaciente(@RequestBody PacienteDTO dto) {
        Paciente dominio = cadastrarPaciente.cadastrarNovoPaciente(PacienteMapper.paraDominio(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(dominio.getUuid())
                .toUri();
        return ResponseEntity.created(uri).body(PacienteMapper.paraDto(dominio));
    }

    @Operation(description = "Retorna um paciente filtrado pelo uuid", summary = "Retorna paciente por uuid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente retornado com sucesso", content = @Content(schema = @Schema(implementation = PacienteDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class)))})
    @GetMapping(value = "/{uuid}", produces = "application/json")
    public ResponseEntity<PacienteDTO> filtrarPacientePorUuid(@PathVariable UUID uuid) {
        Paciente dominio = filtrarPacientePorUuid.findByUuid(uuid);
        return ResponseEntity.ok().body(PacienteMapper.paraDto(dominio));
    }

    @Operation(description = "Atualiza os dados do paciente", summary = "Atualiza paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente atualizado com sucesso", content = @Content(schema = @Schema(implementation = PacienteDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class)))})
    @PutMapping(value = "/{uuid}", produces = "application/json")
    public ResponseEntity<PacienteDTO> atualizarPaciente(@PathVariable UUID uuid, @RequestBody PacienteDTO dto) {
        Paciente dominio = atualizarPaciente.atualizarDadosPaciente(uuid, PacienteMapper.paraDominio(dto));
        return ResponseEntity.ok().body(PacienteMapper.paraDto(dominio));
    }

    @Operation(description = "Deleta paciente filtrado por uuid", summary = "Deleta paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Exclusão do paciente realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class)))})
    @DeleteMapping(value = "/{uuid}", produces = "aplication/json")
    public ResponseEntity<Void> deletarPaciente(@PathVariable UUID uuid) {
        deletarPaciente.deletarPacientePorUuid(uuid);
        return ResponseEntity.noContent().build();
    }
}
