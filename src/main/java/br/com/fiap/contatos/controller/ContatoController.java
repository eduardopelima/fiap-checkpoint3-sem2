package br.com.fiap.contatos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.contatos.dtos.ContatoRequestCreateDto;
import br.com.fiap.contatos.dtos.ContatoRequestUpdateDto;
import br.com.fiap.contatos.dtos.ContatoResponseDto;
import br.com.fiap.contatos.mapper.ContatoMapper;
import br.com.fiap.contatos.repository.ContatoRepository;
import br.com.fiap.contatos.service.ContatoService;
import lombok.RequiredArgsConstructor;
import br.com.fiap.contatos.views.ContatoViewType;
import br.com.fiap.contatos.views.ContatoSimpleView;

/**
 * Controller for managing contacts.
 * <p>
 * This class provides RESTful endpoints for creating, updating, deleting, 
 * and retrieving contact information. It interacts with the service layer 
 * to perform operations and uses DTOs for data transfer.
 * </p>
 */
@RestController
@RequestMapping("contatos")
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;
    private final ContatoMapper contatoMapper;
    private final ContatoRepository contatoRepository;

    /**
     * Retrieves a list of all contacts.
     *
     * @return a ResponseEntity containing a list of ContatoResponseDto objects
     */
    @GetMapping
    public ResponseEntity<List<ContatoResponseDto>> list() {
        List<ContatoResponseDto> dtos = contatoService.list()
                                            .stream()
                                            .map(contatoMapper::toDto)
                                            .toList();
        return ResponseEntity.ok().body(dtos);
    }

    /**
     * Creates a new contact.
     *
     * @param dto the DTO containing the details of the contact to be created
     * @return a ResponseEntity containing the created ContatoResponseDto object
     */
    @PostMapping
    public ResponseEntity<ContatoResponseDto> create(@RequestBody ContatoRequestCreateDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                    contatoMapper.toDto(
                        contatoService.save(contatoMapper.toModel(dto))
                    )
                );
    }

    /**
     * Deletes a contact by its ID.
     *
     * @param id the ID of the contact to be deleted
     * @throws RuntimeException if the contact with the given ID does not exist
     */
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (!contatoService.existsById(id)) {
            throw new RuntimeException("Id inexistente");
        }
        contatoService.delete(id);
    }

    /**
     * Updates an existing contact.
     *
     * @param id  the ID of the contact to be updated
     * @param dto the DTO containing the updated details of the contact
     * @return a ResponseEntity containing the updated ContatoResponseDto object
     * @throws RuntimeException if the contact with the given ID does not exist
     */
    @PutMapping("{id}")
    public ResponseEntity<ContatoResponseDto> update(
        @PathVariable Long id,
        @RequestBody ContatoRequestUpdateDto dto
    ) {
        if (!contatoService.existsById(id)) {
            throw new RuntimeException("Id inexistente");
        }
        return ResponseEntity
                .ok()
                .body(
                    contatoMapper.toDto(
                        contatoService.save(contatoMapper.toModel(dto, id))
                    )
                );
    }

    /**
     * Retrieves a contact by its ID.
     *
     * @param id the ID of the contact to be retrieved
     * @return a ResponseEntity containing the found ContatoResponseDto object
     * @throws RuntimeException if the contact with the given ID does not exist
     */
    @GetMapping("{id}")
    public ResponseEntity<ContatoResponseDto> findById(@PathVariable Long id) {
        return contatoService
                .findById(id)
                .map(contatoMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Id inexistente"));
    }

    /**
     * Finds contacts by name.
     *
     * @param nome the name to search for
     * @param type the view type for the response
     * @return a ResponseEntity containing the found contacts or no content if none are found
     */
    @GetMapping("/find")
    public ResponseEntity<?> findByNome(
                @RequestParam String nome, 
                ContatoViewType type) { 

        switch (type) {
            case SIMPLE:
                return ResponseEntity.ok().body(contatoRepository.findAllByNomeContains(nome, ContatoSimpleView.class));            
        }
        return ResponseEntity.noContent().build();
    }

}
