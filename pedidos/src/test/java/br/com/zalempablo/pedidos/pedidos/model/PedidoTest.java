package br.com.zalempablo.pedidos.pedidos.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PedidoTest {

    @Test
    public void testCriarPedido() {
        Pedido pedido = new Pedido();
        assertNotNull(pedido);
    }
    
    @Test
    public void testItensPedidoVazio() {
        Pedido pedido = new Pedido();
        List<ItemDoPedido> itens = pedido.getItens();
        assertTrue(itens.isEmpty());
    }
    
    @Test
    public void testDefinirStatusPedido() {
        Pedido pedido = new Pedido();
        pedido.setStatus(Status.PRONTO);
        assertEquals(Status.PRONTO, pedido.getStatus());
    }
    
    @Test
    public void testAdicionarItemPedido() {
        Pedido pedido = new Pedido();
        ItemDoPedido item = new ItemDoPedido();
        pedido.getItens().add(item);
        assertTrue(pedido.getItens().contains(item));
    }
}

