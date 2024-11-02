package br.com.fiap.contatos.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.contatos.dtos.ContatoRequestCreateDto;
import br.com.fiap.contatos.dtos.ContatoRequestUpdateDto;
import br.com.fiap.contatos.dtos.ContatoResponseDto;
import br.com.fiap.contatos.model.Contato;

/**
 * Mapper class for converting between Contato entities and their corresponding DTOs.
 * <p>
 * This class uses ModelMapper to facilitate the transformation of 
 * Contato objects to ContatoResponseDto objects and vice versa.
 * </p>
 */
@Component
public class ContatoMapper {
    
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Converts a Contato entity to a ContatoResponseDto.
     *
     * @param contato the Contato entity to be converted
     * @return a ContatoResponseDto representing the provided Contato
     */
    public ContatoResponseDto toDto(Contato contato) {
        return modelMapper.map(contato, ContatoResponseDto.class);
    }

    /**
     * Converts a ContatoRequestCreateDto to a Contato entity.
     *
     * @param contatoRequestCreateDto the DTO containing the contact details to be converted
     * @return a Contato entity representing the provided DTO
     */
    public Contato toModel(ContatoRequestCreateDto contatoRequestCreateDto) {
        return modelMapper.map(contatoRequestCreateDto, Contato.class);
    }

    /**
     * Converts a ContatoRequestUpdateDto to a Contato entity.
     *
     * @param contatoRequestUpdateDto the DTO containing the updated contact details
     * @param id the ID of the contact being updated
     * @return a Contato entity representing the provided DTO
     */
    public Contato toModel(ContatoRequestUpdateDto contatoRequestUpdateDto, Long id) {
        return modelMapper.map(contatoRequestUpdateDto, Contato.class);
    }
    
}
