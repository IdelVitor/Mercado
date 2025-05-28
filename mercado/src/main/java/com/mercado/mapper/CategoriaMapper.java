package com.mercado.mapper;

import com.mercado.domain.Categoria;
import com.mercado.dto.CategoriaDTO;

public class CategoriaMapper {

    public static CategoriaDTO toDto(Categoria categoria) {
        if (categoria == null) return null;
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        dto.setDescricao(categoria.getDescricao());
        dto.setAtivo(categoria.isAtivo());
        dto.setDataCriacao(categoria.getDataCriacao());
        dto.setDataAtualizacao(categoria.getDataAtualizacao());
        return dto;
    }

    public static Categoria toEntity(CategoriaDTO dto) {
        if (dto == null) return null;
        Categoria categoria = new Categoria();
        categoria.setId(dto.getId());
        categoria.setNome(dto.getNome());
        categoria.setDescricao(dto.getDescricao());
        categoria.setAtivo(dto.isAtivo());
        categoria.setDataCriacao(dto.getDataCriacao());
        categoria.setDataAtualizacao(dto.getDataAtualizacao());
        return categoria;
    }
}
