package com.hello.repository;

import com.hello.model.Pedido;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@Cacheable("pedidos")
public interface PedidosRepository extends MongoRepository<Pedido, Long> {
    Optional<Pedido> findById(Long id);
}
