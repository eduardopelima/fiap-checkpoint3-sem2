package br.com.fiap.contatos.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.contatos.dtos.ContatoRequestCreateDto;
import br.com.fiap.contatos.dtos.ContatoRequestUpdateDto;
import br.com.fiap.contatos.dtos.ContatoResponseDto;
import br.com.fiap.contatos.model.Contato;

@Component
public class ContatoMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ContatoResponseDto toDto(Contato contato) {
        return modelMapper.map(contato, ContatoResponseDto.class);
    }

    public Contato toModel(ContatoRequestCreateDto contatoRequestCreateDto) {
        return modelMapper.map(contatoRequestCreateDto, Contato.class);
    }

    public Contato toModel(ContatoRequestUpdateDto contatoRequestUpdateDto, Long id) {
        return modelMapper.map(contatoRequestUpdateDto, Contato.class);
    }
    
}
