package com.hello.manager;

import com.hello.cache.BumexMemcached;
import com.hello.dao.PedidosDAO;
import com.hello.model.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PedidosManager {

    private static Logger logger = LoggerFactory.getLogger(PedidosManager.class);
    private BumexMemcached bumexMemcached = BumexMemcached.getInstance();

    public PedidosManager() {}

    // CREATE / UPDATE
    public void insertOrCreate(Pedido nuevoPedido) {
        try {
            // Query for id
            Pedido pedidoExistente = (Pedido) bumexMemcached.get(nuevoPedido.getId());

            if (pedidoExistente == null) {
                // add to cache
                this.bumexMemcached.set(nuevoPedido.getId(), nuevoPedido);
            } else {
                // update data in cache
                this.bumexMemcached.set(pedidoExistente.getId(), nuevoPedido);
            }
            // this method should auto-generate id and return it so I can save it in the cache.
            PedidosDAO.insertOrUpdate(nuevoPedido);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    // DELETE
    public void delete(long id) {
        try {
            // Delete from cache if applicable
            this.bumexMemcached.delete(String.valueOf(id));
            // Delete from database
            PedidosDAO.delete(id);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    // GET
    public Pedido get(long id) {
        Pedido pedido = (Pedido) this.bumexMemcached.get(id);
        return pedido != null ? pedido : PedidosDAO.select(id);
    }
}
