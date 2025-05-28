package com.mercado.controller;

import com.mercado.domain.Categoria;
import com.mercado.dto.CategoriaDTO;
import com.mercado.mapper.CategoriaMapper;
import com.mercado.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaDTO> criar(@RequestBody @Valid CategoriaDTO dto) {
        Categoria entidade = CategoriaMapper.toEntity(dto);
        Categoria salvo = categoriaService.salvar(entidade);
        return ResponseEntity.ok(CategoriaMapper.toDto(salvo));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listar() {
        List<CategoriaDTO> listaDto = categoriaService.listar()
                .stream()
                .map(CategoriaMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscar(@PathVariable Long id) {
        return categoriaService.buscarPorId(id)
                .map(CategoriaMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid CategoriaDTO dto) {
        if (categoriaService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Categoria entidade = CategoriaMapper.toEntity(dto);
        entidade.setId(id);
        Categoria atualizado = categoriaService.atualizar(entidade);
        return ResponseEntity.ok(CategoriaMapper.toDto(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (categoriaService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
