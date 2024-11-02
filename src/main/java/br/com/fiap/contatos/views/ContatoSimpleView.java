package br.com.fiap.contatos.views;

/**
 * View interface for a simplified representation of a contact.
 * <p>
 * This interface defines a contract for retrieving the name of a contact 
 * in a simplified view. Implementations of this interface will provide 
 * the necessary data for displaying a contact's name without exposing 
 * the entire contact entity.
 * </p>
 */
public interface ContatoSimpleView {
    
    /**
     * Retrieves the name of the contact.
     *
     * @return the name of the contact
     */
    String getNome();
}
