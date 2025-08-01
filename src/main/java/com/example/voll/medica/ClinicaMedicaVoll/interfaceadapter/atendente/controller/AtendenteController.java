package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.atendente.controller;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.AtualizarAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.CadastrarAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.DeletarAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.FiltrarAtendentePorUuid;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.atendente.dto.AtendenteEntradaDTO;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.atendente.dto.AtendenteRetornoDTO;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.atendente.mapper.AtendenteMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/atendente")
public class AtendenteController {

    private final CadastrarAtendente cadastrarAtendente;
    private final FiltrarAtendentePorUuid filtrarAtendentePorUuid;
    private final AtualizarAtendente atualizarAtendente;
    private final DeletarAtendente deletarAtendente;

    public AtendenteController(CadastrarAtendente cadastrarAtendente, FiltrarAtendentePorUuid filtrarAtendentePorUuid,
                               AtualizarAtendente atualizarAtendente,
                               DeletarAtendente deletarAtendente) {
        this.cadastrarAtendente = cadastrarAtendente;
        this.filtrarAtendentePorUuid = filtrarAtendentePorUuid;
        this.atualizarAtendente = atualizarAtendente;
        this.deletarAtendente = deletarAtendente;
    }

    @PostMapping
    public ResponseEntity<AtendenteRetornoDTO> cadastrarAtendente(@RequestBody AtendenteEntradaDTO dto) {
        Atendente dominio = cadastrarAtendente.cadastrarNovoAtendente(AtendenteMapper.paraDominio(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(dominio.getUuid())
                .toUri();
        return ResponseEntity.created(uri).body(AtendenteMapper.paraDto(dominio));
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<AtendenteRetornoDTO> filtrarPorUuid(@PathVariable UUID uuid) {
        Atendente dominio = filtrarAtendentePorUuid.findByUuid(uuid);
        return ResponseEntity.ok().body(AtendenteMapper.paraDto(dominio));
    }

    @PutMapping(value = "/{uuid}")
    public ResponseEntity<AtendenteRetornoDTO> atualizarAtendente(@PathVariable UUID uuid,
                                                                  @RequestBody AtendenteEntradaDTO dto) {
        Atendente dominio = atualizarAtendente.atualizarDadosAtendente(uuid, AtendenteMapper.paraDominio(dto));
        return ResponseEntity.ok().body(AtendenteMapper.paraDto(dominio));
    }

    @DeleteMapping(value = "/{uuid}")
    public ResponseEntity<Void> deletarAtendente(@PathVariable UUID uuid) {
        deletarAtendente.deletarAtendentePorUuid(uuid);
        return ResponseEntity.noContent().build();
    }
}
