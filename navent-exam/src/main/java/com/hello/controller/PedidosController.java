package com.hello.controller;

import com.hello.manager.PedidosManager;
import com.hello.model.Pedido;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    private final PedidosManager manager;

    public PedidosController(PedidosManager manager) {
        this.manager = manager;
    }

    // Create
    @PostMapping("/guardar")
    public @ResponseBody void guardar(@RequestBody Pedido nuevoPedido) {
        this.manager.insertOrCreate(nuevoPedido);
    }

    // Delete
    @DeleteMapping("/{id}")
    public @ResponseBody void delete(@PathVariable Long id) {
        this.manager.delete(id);
    }

    // Get
    @GetMapping("/{id}")
    public @ResponseBody Pedido get(@PathVariable Long id) {
        return this.manager.get(id);
    }
}
