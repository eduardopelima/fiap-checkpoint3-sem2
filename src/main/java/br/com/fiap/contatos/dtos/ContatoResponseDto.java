package br.com.fiap.contatos.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for the response containing contact details.
 * <p>
 * This class encapsulates the information returned when retrieving 
 * a contact, including the contact's ID and name.
 * </p>
 */
@Getter
@Setter
public class ContatoResponseDto {
    
    /**
     * The unique identifier of the contact.
     */
    private Long id;
    
    /**
     * The name of the contact.
     */
    private String nome;
}
