package com.hello.dao;

import com.hello.model.Pedido;
import com.hello.repository.PedidosRepository;
import org.springframework.stereotype.Component;

@Component
public class PedidosDAO {

    /** Clase provista por el ejercicio, asumir como ya implementada. */

    public PedidosDAO(PedidosRepository repository) {

    }

    public static void insertOrUpdate(Pedido pedido) {

    }

    public static void delete(long id) {

    }

    public static Pedido select(long id) {
        return null;
    }
}
