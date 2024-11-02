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

@RestController
@RequestMapping("contatos")
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;
    private final ContatoMapper contatoMapper;
    private final ContatoRepository contatoRepository;

    @GetMapping
    public ResponseEntity<List<ContatoResponseDto>> list() {
        List<ContatoResponseDto> dtos = contatoService.list()
                                            .stream()
                                            .map(contatoMapper::toDto)
                                            .toList();
        return ResponseEntity.ok().body(dtos);
    }

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

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (!contatoService.existsById(id)) {
            throw new RuntimeException("Id inexistente");
        }
        contatoService.delete(id);
    }

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

    @GetMapping("{id}")
    public ResponseEntity<ContatoResponseDto> findById(@PathVariable Long id) {
        return contatoService
                .findById(id)
                .map(contatoMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Id inexistente"));
    }

    @GetMapping("/find")
    public  ResponseEntity<?> findByNome(
                @RequestParam String nome, 
                ContatoViewType type) { 

        switch (type) {
            case SIMPLE:
                return ResponseEntity.ok().body(contatoRepository.findAllByNomeContains(nome, ContatoSimpleView.class));            
        }
        return ResponseEntity.noContent().build();
    }

}
