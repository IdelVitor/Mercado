package com.mercado.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String endereco;

    public ClienteDTO(com.mercado.domain.Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.cpf = cliente.getCpf();
        this.endereco = cliente.getEndereco();
    }

}
