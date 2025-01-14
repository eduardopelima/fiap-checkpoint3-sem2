package br.com.fiap.contatos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Entity representing a contact.
 * <p>
 * This class defines the contact entity with its attributes, which will 
 * be mapped to a database table. It includes an auto-generated ID and the 
 * contact's name.
 * </p>
 */
@Entity
@Data
public class Contato {
    
    /**
     * The unique identifier for the contact. 
     * This value is automatically generated by the database.
     */
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    /**
     * The name of the contact.
     */
    String nome;
}
