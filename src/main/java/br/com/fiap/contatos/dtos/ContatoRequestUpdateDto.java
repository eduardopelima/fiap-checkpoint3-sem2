package br.com.fiap.contatos.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoRequestUpdateDto {
    private Long id;
    private String nome;
}
