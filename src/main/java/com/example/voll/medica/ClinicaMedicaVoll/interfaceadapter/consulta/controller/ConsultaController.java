package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.consulta.controller;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.usecases.*;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.Consulta;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.StatusConsulta;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.consulta.dto.ConsultaDTO;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.consulta.mapper.ConsultaMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/consulta")
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

    @PostMapping
    public ResponseEntity<ConsultaDTO> agendarConsulta(@RequestBody ConsultaDTO dto) {
        Consulta dominio = agendarConsulta.salvarNovaConsulta(ConsultaMapper.paraDominio(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(dominio.getUuid())
                .toUri();
        return ResponseEntity.created(uri).body(ConsultaMapper.paraDto(dominio));
    }

    @PutMapping(value = "/cancelar/{uuid}")
    public ResponseEntity<Void> cancelarConsulta(@PathVariable UUID uuid,
                                                 @RequestParam(defaultValue = "CANCELADO") String motivoCancelamento) {
        cancelarConsulta.cancelarConsultaPorUuid(uuid, StatusConsulta.valueOf(motivoCancelamento));
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/porPaciente/{cpfPaciente}")
    public ResponseEntity<List<ConsultaDTO>> filtrarConsultaPorPaciente(@PathVariable String cpfPaciente) {
        List<Consulta> dominio = filtrarConsultasPorPaciente.listarConsultasPorCpfPaciente(cpfPaciente);
        return ResponseEntity.ok().body(dominio.stream().map(ConsultaMapper::paraDto).toList());
    }

    @GetMapping(value = "/porMedico/{crmMedico}")
    public ResponseEntity<List<ConsultaDTO>> filtrarConsultaPorMedicoEDatas(@PathVariable String crmMedico,
                                                                            @RequestParam(defaultValue = "") LocalDate dataInicial,
                                                                            @RequestParam(defaultValue = "") LocalDate dataFinal) {
        List<Consulta> dominio = filtrarConsultasPorMedicoEDatas.listarConsultasPorCrmMedicoEDatas(crmMedico,
                dataInicial, dataFinal);
        return ResponseEntity.ok().body(dominio.stream().map(ConsultaMapper::paraDto).toList());
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<ConsultaDTO> filtrarConsultaPorUuid(@PathVariable UUID uuid) {
        Consulta dominio = filtrarConsultasPorUuid.findByUuid(uuid);
        return ResponseEntity.ok().body(ConsultaMapper.paraDto(dominio));
    }
}
