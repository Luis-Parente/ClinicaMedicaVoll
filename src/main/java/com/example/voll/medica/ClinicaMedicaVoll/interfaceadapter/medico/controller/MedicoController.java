package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.medico.controller;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases.*;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.medico.dto.MedicoDTO;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.medico.mapper.MedicoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/medico")
public class MedicoController {

    private final AtualizarCadastroMedico atualizarCadastroMedico;
    private final CadastrarMedico cadastrarMedico;
    private final DesativarCadastroMedico desativarCadastroMedico;
    private final FiltrarMedicosPorUuid filtrarMedicosPorUuid;
    private final ListarTodosMedicos listarTodosMedicos;
    private final ReativarCadastroMedico reativarCadastroMedico;

    public MedicoController(AtualizarCadastroMedico atualizarCadastroMedico, CadastrarMedico cadastrarMedico,
                            DesativarCadastroMedico desativarCadastroMedico,
                            FiltrarMedicosPorUuid filtrarMedicosPorUuid,
                            ListarTodosMedicos listarTodosMedicos, ReativarCadastroMedico reativarCadastroMedico) {
        this.atualizarCadastroMedico = atualizarCadastroMedico;
        this.cadastrarMedico = cadastrarMedico;
        this.desativarCadastroMedico = desativarCadastroMedico;
        this.filtrarMedicosPorUuid = filtrarMedicosPorUuid;
        this.listarTodosMedicos = listarTodosMedicos;
        this.reativarCadastroMedico = reativarCadastroMedico;
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> cadastrarMedico(@RequestBody MedicoDTO dto) {
        Medico dominio = cadastrarMedico.cadastrarNovoMedico(MedicoMapper.paraDominio(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(dominio.getUuid())
                .toUri();
        return ResponseEntity.created(uri).body(MedicoMapper.paraDto(dominio));
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<MedicoDTO> filtrarMedicoPorUuid(@RequestParam UUID uuid) {
        Medico dominio = filtrarMedicosPorUuid.findByUuid(uuid);
        return ResponseEntity.ok().body(MedicoMapper.paraDto(dominio));
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> listarTodosMedicos() {
        List<Medico> dominio = listarTodosMedicos.listarMedicos();
        return ResponseEntity.ok().body(dominio.stream().map(MedicoMapper::paraDto).toList());
    }

    @PutMapping(value = "/{uuid}")
    public ResponseEntity<MedicoDTO> atualizarMedico(@RequestParam UUID uuid, @RequestBody MedicoDTO dto) {
        Medico dominio = atualizarCadastroMedico.atualizarDadosMedico(uuid, MedicoMapper.paraDominio(dto));
        return ResponseEntity.ok().body(MedicoMapper.paraDto(dominio));
    }

    @PutMapping(value = "/desativar/{uuid}")
    public ResponseEntity<Void> desativarCadastroMedico(@RequestParam UUID uuid) {
        desativarCadastroMedico.desativarMedico(uuid);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/reativar/{uuid}")
    public ResponseEntity<Void> reativarCadastroMedico(@RequestParam UUID uuid) {
        reativarCadastroMedico.reativarMedico(uuid);
        return ResponseEntity.noContent().build();
    }
}
