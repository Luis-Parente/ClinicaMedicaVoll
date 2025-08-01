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

    private final AtualizarMedico atualizarMedico;
    private final CadastrarMedico cadastrarMedico;
    private final DesativarCadastroMedico desativarCadastroMedico;
    private final FiltrarMedicosPorUuid filtrarMedicosPorUuid;
    private final ListarMedicos listarMedicos;
    private final ReativarCadastroMedico reativarCadastroMedico;
    private final DeletarMedico deletarMedico;

    public MedicoController(AtualizarMedico atualizarMedico, CadastrarMedico cadastrarMedico,
                            DesativarCadastroMedico desativarCadastroMedico,
                            FiltrarMedicosPorUuid filtrarMedicosPorUuid,
                            ListarMedicos listarMedicos, ReativarCadastroMedico reativarCadastroMedico,
                            DeletarMedico deletarMedico) {
        this.atualizarMedico = atualizarMedico;
        this.cadastrarMedico = cadastrarMedico;
        this.desativarCadastroMedico = desativarCadastroMedico;
        this.filtrarMedicosPorUuid = filtrarMedicosPorUuid;
        this.listarMedicos = listarMedicos;
        this.reativarCadastroMedico = reativarCadastroMedico;
        this.deletarMedico = deletarMedico;
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> cadastrarMedico(@RequestBody MedicoDTO dto) {
        Medico dominio = cadastrarMedico.cadastrarNovoMedico(MedicoMapper.paraDominio(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(dominio.getUuid())
                .toUri();
        return ResponseEntity.created(uri).body(MedicoMapper.paraDto(dominio));
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<MedicoDTO> filtrarMedicoPorUuid(@PathVariable UUID uuid) {
        Medico dominio = filtrarMedicosPorUuid.findByUuid(uuid);
        return ResponseEntity.ok().body(MedicoMapper.paraDto(dominio));
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> listarTodosMedicos() {
        List<Medico> dominio = listarMedicos.listarTodosMedicos();
        return ResponseEntity.ok().body(dominio.stream().map(MedicoMapper::paraDto).toList());
    }

    @PutMapping(value = "/{uuid}")
    public ResponseEntity<MedicoDTO> atualizarMedico(@PathVariable UUID uuid, @RequestBody MedicoDTO dto) {
        Medico dominio = atualizarMedico.atualizarDadosMedico(uuid, MedicoMapper.paraDominio(dto));
        return ResponseEntity.ok().body(MedicoMapper.paraDto(dominio));
    }

    @PutMapping(value = "/desativar/{uuid}")
    public ResponseEntity<Void> desativarCadastroMedico(@PathVariable UUID uuid) {
        desativarCadastroMedico.desativarMedico(uuid);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/reativar/{uuid}")
    public ResponseEntity<Void> reativarCadastroMedico(@PathVariable UUID uuid) {
        reativarCadastroMedico.reativarMedico(uuid);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{uuid}")
    public ResponseEntity<Void> deletarMedico(@PathVariable UUID uuid) {
        deletarMedico.deletarMedicoPorUuid(uuid);
        return ResponseEntity.noContent().build();
    }
}
