package br.com.zalempablo.pedidos.pedidos.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemDoPedidoDtoTest {

    private ItemDoPedidoDto itemDoPedidoDto;

    @BeforeEach
    public void setUp() {
        // Inicialize o objeto ItemDoPedidoDto antes de cada teste
        itemDoPedidoDto = new ItemDoPedidoDto(1L, 5, "Produto A");
    }

    @Test
    public void testGetId() {
        assertEquals(1L, itemDoPedidoDto.getId());
    }

    @Test
    public void testGetQuantidade() {
        assertEquals(5, itemDoPedidoDto.getQuantidade());
    }

    @Test
    public void testGetDescricao() {
        assertEquals("Produto A", itemDoPedidoDto.getDescricao());
    }

    @Test
    public void testSetId() {
        itemDoPedidoDto.setId(2L);
        assertEquals(2L, itemDoPedidoDto.getId());
    }

    @Test
    public void testSetQuantidade() {
        itemDoPedidoDto.setQuantidade(10);
        assertEquals(10, itemDoPedidoDto.getQuantidade());
    }

    @Test
    public void testSetDescricao() {
        itemDoPedidoDto.setDescricao("Produto B");
        assertEquals("Produto B", itemDoPedidoDto.getDescricao());
    }

    @Test
    public void testNoArgsConstructor() {
        ItemDoPedidoDto newItem = new ItemDoPedidoDto();
        assertNull(newItem.getId());
        assertNull(newItem.getQuantidade());
        assertNull(newItem.getDescricao());
    }

    @Test
    public void testAllArgsConstructor() {
        ItemDoPedidoDto newItem = new ItemDoPedidoDto(3L, 2, "Produto C");
        assertEquals(3L, newItem.getId());
        assertEquals(2, newItem.getQuantidade());
        assertEquals("Produto C", newItem.getDescricao());
    }
}

