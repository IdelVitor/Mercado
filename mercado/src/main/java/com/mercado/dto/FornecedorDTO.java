package com.mercado.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorDTO {

    private Long id;

    @NotBlank(message = "O nome do fornecedor é obrigatório")
    @Size(max = 100)
    private String nome;

    @NotBlank(message = "O CNPJ é obrigatório")
    @Size(max = 18)
    private String cnpj;

    @Size(max = 100)
    private String endereco;

    @Size(max = 20)
    private String telefone;
}
