package com.mercado.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {
    private Long id;
    private Double valor;
    private LocalDateTime dataPagamento;
    private String formaPagamento;
    private Long pedidoId;
}
