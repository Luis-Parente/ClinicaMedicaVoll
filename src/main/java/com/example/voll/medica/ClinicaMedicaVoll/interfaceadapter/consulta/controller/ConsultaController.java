package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.consulta.controller;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.usecases.*;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.CampoInvalidoExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.Consulta;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.StatusConsulta;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.consulta.dto.ConsultaDTO;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.consulta.mapper.ConsultaMapper;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.handler.dto.ErroCustomizadoDTO;
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
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/consulta")
@Tag(name = "Consulta", description = "Controller para consulta")
public class ConsultaController {

    private final AgendarConsulta agendarConsulta;
    private final CancelarConsulta cancelarConsulta;
    private final FiltrarConsultasPorMedicoEDatas filtrarConsultasPorMedicoEDatas;
    private final FiltrarConsultasPorPaciente filtrarConsultasPorPaciente;
    private final FiltrarConsultasPorUuid filtrarConsultasPorUuid;

    public ConsultaController(AgendarConsulta agendarConsulta, CancelarConsulta cancelarConsulta,
                              FiltrarConsultasPorMedicoEDatas filtrarConsultasPorMedicoEDatas,
                              FiltrarConsultasPorPaciente filtrarConsultasPorPaciente,
                              FiltrarConsultasPorUuid filtrarConsultasPorUuid) {
        this.agendarConsulta = agendarConsulta;
        this.cancelarConsulta = cancelarConsulta;
        this.filtrarConsultasPorMedicoEDatas = filtrarConsultasPorMedicoEDatas;
        this.filtrarConsultasPorPaciente = filtrarConsultasPorPaciente;
        this.filtrarConsultasPorUuid = filtrarConsultasPorUuid;
    }

    @Operation(description = "Insere nova consulta", summary = "Inserir consulta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Consulta inserida com sucesso", content = @Content(schema = @Schema(implementation = ConsultaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "409", description = "Conflict", content = @Content(schema = @Schema(implementation = CampoInvalidoExcecao.class))),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class)))})
    @PostMapping(produces = "application/json")
    public ResponseEntity<ConsultaDTO> agendarConsulta(@RequestBody ConsultaDTO dto) {
        Consulta dominio = agendarConsulta.salvarNovaConsulta(ConsultaMapper.paraDominio(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(dominio.getUuid())
                .toUri();
        return ResponseEntity.created(uri).body(ConsultaMapper.paraDto(dominio));
    }

    @Operation(description = "Atualiza consulta inserindo motivo do cancelamento", summary = "Cancelar consulta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Consulta cancelada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class)))})
    @PutMapping(value = "/cancelar/{uuid}", produces = "application/json")
    public ResponseEntity<Void> cancelarConsulta(@PathVariable UUID uuid,
                                                 @RequestParam(defaultValue = "CANCELADO") String motivoCancelamento) {
        cancelarConsulta.cancelarConsultaPorUuid(uuid, StatusConsulta.valueOf(motivoCancelamento));
        return ResponseEntity.noContent().build();
    }


    @Operation(description = "Retorna lista de consultas filtradas pelo cpf do paciente", summary = "Retorna lista filtrada de consulta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consultas retornadas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden")})
    @GetMapping(value = "/porPaciente/{cpfPaciente}", produces = "application/json")
    public ResponseEntity<List<ConsultaDTO>> filtrarConsultaPorPaciente(@PathVariable String cpfPaciente) {
        List<Consulta> dominio = filtrarConsultasPorPaciente.listarConsultasPorCpfPaciente(cpfPaciente);
        return ResponseEntity.ok().body(dominio.stream().map(ConsultaMapper::paraDto).toList());
    }

    @Operation(description = "Retorna lista de consultas filtradas pelo crm do medico e a data da consulta", summary = "Retorna lista filtrada de consulta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consultas retornadas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden")})
    @GetMapping(value = "/porMedico/{crmMedico}", produces = "application/json")
    public ResponseEntity<List<ConsultaDTO>> filtrarConsultaPorMedicoEDatas(@PathVariable String crmMedico,
                                                                            @RequestParam(defaultValue = "") LocalDate dataInicial,
                                                                            @RequestParam(defaultValue = "") LocalDate dataFinal) {
        List<Consulta> dominio = filtrarConsultasPorMedicoEDatas.listarConsultasPorCrmMedicoEDatas(crmMedico,
                dataInicial, dataFinal);
        return ResponseEntity.ok().body(dominio.stream().map(ConsultaMapper::paraDto).toList());
    }

    @Operation(description = "Retorna um atendente filtrado pelo uuid", summary = "Retorna atendente por uuid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta retornada com sucesso", content = @Content(schema = @Schema(implementation = ConsultaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErroCustomizadoDTO.class)))})
    @GetMapping(value = "/{uuid}", produces = "application/json")
    public ResponseEntity<ConsultaDTO> filtrarConsultaPorUuid(@PathVariable UUID uuid) {
        Consulta dominio = filtrarConsultasPorUuid.findByUuid(uuid);
        return ResponseEntity.ok().body(ConsultaMapper.paraDto(dominio));
    }
}
