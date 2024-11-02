package br.com.fiap.contatos.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for creating a new contact.
 * <p>
 * This class encapsulates the information required to create a 
 * new contact, specifically the contact's name.
 * </p>
 */
@Getter
@Setter
public class ContatoRequestCreateDto {
    
    /**
     * The name of the contact to be created.
     */
    private String nome;
}
