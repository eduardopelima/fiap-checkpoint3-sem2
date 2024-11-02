package br.com.fiap.contatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.contatos.model.Contato;
import br.com.fiap.contatos.repository.ContatoRepository;

/**
 * Service class for managing contacts.
 * <p>
 * This class provides methods for performing operations related to 
 * contacts, including retrieving, saving, updating, and deleting 
 * contact entities.
 * </p>
 */
@Service
public class ContatoService {

    @Autowired
    ContatoRepository contatoRepository;

    /**
     * Retrieves all contacts.
     *
     * @return a list of all contacts
     */
    public List<Contato> list() {
        return contatoRepository.findAll();
    }

    /**
     * Finds a contact by its ID.
     *
     * @param id the unique identifier of the contact
     * @return an Optional containing the found contact, or empty if not found
     */
    public Optional<Contato> findById(long id) {
        return contatoRepository.findById(id);
    } 

    /**
     * Saves a new contact or updates an existing one.
     *
     * @param contato the contact entity to save
     * @return the saved contact entity
     */
    public Contato save(Contato contato) {
        return contatoRepository.save(contato);
    }

    /**
     * Checks if a contact exists by its ID.
     *
     * @param id the unique identifier of the contact
     * @return true if the contact exists, false otherwise
     */
    public boolean existsById(long id) {
        return contatoRepository.existsById(id);
    }

    /**
     * Deletes a contact by its ID.
     *
     * @param id the unique identifier of the contact to delete
     */
    public void delete(Long id) {
        contatoRepository.deleteById(id);
    }

}
