package br.com.zalempablo.pedidos.pedidos.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemDoPedidoTest {
    private ItemDoPedido item;

    @BeforeEach
    public void setUp() {
        item = new ItemDoPedido();
    }

    @Test
    public void testQuantidadeNotNull() {
        // Configura o item com quantidade como nula
        assertThrows(IllegalArgumentException.class, () -> item.setQuantidade(null));
    }

    @Test
    public void testQuantidadePositive() {
        // Configura o item com quantidade negativa
        assertThrows(IllegalArgumentException.class, () -> item.setQuantidade(-1));
    }

    @Test
    public void testPedido() {
        Pedido pedido = new Pedido();
        item.setPedido(pedido);
        assertEquals(pedido, item.getPedido());
    }
}

