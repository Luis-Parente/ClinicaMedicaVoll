package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.paciente.controller;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases.AtualizarPaciente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases.CadastrarPaciente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases.DeletarPaciente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases.FiltrarPacientePorUuid;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.paciente.Paciente;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.paciente.dto.PacienteDTO;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.paciente.mapper.PacienteMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/paciente")
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

    @PostMapping
    public ResponseEntity<PacienteDTO> cadastrarPaciente(@RequestBody PacienteDTO dto) {
        Paciente dominio = cadastrarPaciente.cadastrarNovoPaciente(PacienteMapper.paraDominio(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(dominio.getUuid())
                .toUri();
        return ResponseEntity.created(uri).body(PacienteMapper.paraDto(dominio));
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<PacienteDTO> filtrarPacientePorUuid(@PathVariable UUID uuid) {
        Paciente dominio = filtrarPacientePorUuid.findByUuid(uuid);
        return ResponseEntity.ok().body(PacienteMapper.paraDto(dominio));
    }

    @PutMapping(value = "/{uuid}")
    public ResponseEntity<PacienteDTO> atualizarPaciente(@PathVariable UUID uuid, @RequestBody PacienteDTO dto) {
        Paciente dominio = atualizarPaciente.atualizarDadosPaciente(uuid, PacienteMapper.paraDominio(dto));
        return ResponseEntity.ok().body(PacienteMapper.paraDto(dominio));
    }

    @DeleteMapping(value = "/{uuid}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable UUID uuid) {
        deletarPaciente.deletarPacientePorUuid(uuid);
        return ResponseEntity.noContent().build();
    }
}
