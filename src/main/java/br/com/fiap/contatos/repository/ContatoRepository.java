package br.com.fiap.contatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.contatos.model.Contato;

/**
 * Repository interface for accessing contact data.
 * <p>
 * This interface extends JpaRepository, providing CRUD operations 
 * and additional query methods for the Contato entity.
 * </p>
 */
@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    
    /**
     * Retrieves a contact by its name.
     *
     * @param nome the name of the contact to retrieve
     * @param type the class type of the expected result
     * @param <T> the type of the result
     * @return the contact matching the provided name, converted to the specified type
     */
    <T> T findByNome(String nome, Class<T> type);
    
    /**
     * Retrieves all contacts with an exact name match.
     *
     * @param nome the name of the contacts to retrieve
     * @param type the class type of the expected result
     * @param <T> the type of the result
     * @return a list of contacts matching the provided name, converted to the specified type
     */
    <T> List<T> findAllByNome(String nome, Class<T> type);
    
    /**
     * Retrieves all contacts whose names contain the specified string.
     *
     * @param nome the substring to search for in contact names
     * @param type the class type of the expected result
     * @param <T> the type of the result
     * @return a list of contacts whose names contain the specified substring, 
     *         converted to the specified type
     */
    <T> List<T> findAllByNomeContains(String nome, Class<T> type);
}
