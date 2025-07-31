package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.endereco.mapper;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.endereco.Endereco;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.endereco.dto.EnderecoDTO;

public class EnderecoMapper {

    public static Endereco paraDominio(EnderecoDTO dto) {
        return new Endereco(dto.logradouro(), dto.numero(), dto.complemento(), dto.cidade(), dto.uf(), dto.cep());
    }

    public static EnderecoDTO paraDto(Endereco dominio) {
        return new EnderecoDTO(dominio.getLogradouro(), dominio.getNumero(), dominio.getComplemento(),
                dominio.getCidade(), dominio.getUf(), dominio.getCep());
    }
}
