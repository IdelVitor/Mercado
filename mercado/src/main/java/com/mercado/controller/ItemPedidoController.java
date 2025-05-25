package com.mercado.controller;

import com.mercado.domain.ItemPedido;
import com.mercado.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itempedidos")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping
    public ResponseEntity<ItemPedido> criar(@RequestBody ItemPedido itemPedido) {
        ItemPedido novoItem = itemPedidoService.salvar(itemPedido);
        return ResponseEntity.ok(novoItem);
    }

    @GetMapping
    public ResponseEntity<List<ItemPedido>> listar() {
        return ResponseEntity.ok(itemPedidoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> buscar(@PathVariable Long id) {
        return itemPedidoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedido> atualizar(@PathVariable Long id, @RequestBody ItemPedido itemPedido) {
        if (!itemPedidoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        itemPedido.setId(id);
        ItemPedido atualizado = itemPedidoService.atualizar(itemPedido);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!itemPedidoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        itemPedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
