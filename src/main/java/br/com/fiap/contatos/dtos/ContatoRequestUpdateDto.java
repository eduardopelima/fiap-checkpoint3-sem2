package br.com.fiap.contatos.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for updating an existing contact.
 * <p>
 * This class encapsulates the information required to update 
 * an existing contact, including the contact's ID and name.
 * </p>
 */
@Getter
@Setter
public class ContatoRequestUpdateDto {
    
    /**
     * The ID of the contact to be updated.
     */
    private Long id;
    
    /**
     * The new name of the contact.
     */
    private String nome;
}
