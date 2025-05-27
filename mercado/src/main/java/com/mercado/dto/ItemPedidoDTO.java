package com.mercado.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {
    private Long id;
    private Long pedidoId;
    private Long produtoId;
    private Integer quantidade;
    private Double precoUnitario;
    private Double precoTotal;
}
