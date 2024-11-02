package br.com.fiap.contatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Contatos application.
 * <p>
 * This class serves as the main application class for the Spring Boot 
 * application. It is responsible for bootstrapping the application and 
 * initializing the Spring context.
 * </p>
 */
@SpringBootApplication
public class ContatosApplication {

    /**
     * The main method that starts the application.
     *
     * @param args command-line arguments passed during the application startup
     */
    public static void main(String[] args) {
        SpringApplication.run(ContatosApplication.class, args);
    }

}
