package br.com.zalempablo.pedidos.pedidos.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.zalempablo.pedidos.pedidos.model.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PedidoDtoTest {

    private PedidoDto pedidoDto;

    @BeforeEach
    public void setUp() {
        pedidoDto = new PedidoDto();
    }

    @Test
    public void testId() {
        Long id = 1L;
        pedidoDto.setId(id);
        assertEquals(id, pedidoDto.getId());
    }

    @Test
    public void testDataHora() {
        LocalDateTime dataHora = LocalDateTime.now();
        pedidoDto.setDataHora(dataHora);
        assertEquals(dataHora, pedidoDto.getDataHora());
    }

    @Test
    public void testStatus() {
        Status status = Status.PAGO;
        pedidoDto.setStatus(status);
        assertEquals(status, pedidoDto.getStatus());
    }

    @Test
    public void testItens() {
        List<ItemDoPedidoDto> itens = new ArrayList<>();
        ItemDoPedidoDto item1 = new ItemDoPedidoDto();
        ItemDoPedidoDto item2 = new ItemDoPedidoDto();
        itens.add(item1);
        itens.add(item2);

        pedidoDto.setItens(itens);

        assertNotNull(pedidoDto.getItens());
        assertEquals(2, pedidoDto.getItens().size());
    }
}
