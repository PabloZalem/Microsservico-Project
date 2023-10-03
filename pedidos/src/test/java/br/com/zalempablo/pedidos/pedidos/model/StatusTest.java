package br.com.zalempablo.pedidos.pedidos.model;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.EnumSet;

import org.junit.jupiter.api.Test;

public class StatusTest {

    @Test
    public void testEnumValues() {
        // Verifica se todos os valores da enumeração estão presentes
        assertEquals(8, Status.values().length);
        assertTrue(EnumSet.allOf(Status.class).containsAll(Arrays.asList(Status.values())));
    }

    @Test
    public void testEnumOrder() {
        // Verifica a ordem dos valores na enumeração
        Status[] expectedOrder = {
            Status.REALIZADO,
            Status.CANCELADO,
            Status.PAGO,
            Status.NAO_AUTORIZADO,
            Status.CONFIRMADO,
            Status.PRONTO,
            Status.SAIU_PARA_ENTREGA,
            Status.ENTREGUE
        };

        assertArrayEquals(expectedOrder, Status.values());
    }
    
    @Test
    public void testEnumToString() {
        // Verifica se o método toString() retorna o nome correto
        assertEquals("REALIZADO", Status.REALIZADO.toString());
        assertEquals("CANCELADO", Status.CANCELADO.toString());
        assertEquals("PAGO", Status.PAGO.toString());
        assertEquals("NAO_AUTORIZADO", Status.NAO_AUTORIZADO.toString());
        assertEquals("CONFIRMADO", Status.CONFIRMADO.toString());
        assertEquals("PRONTO", Status.PRONTO.toString());
        assertEquals("SAIU_PARA_ENTREGA", Status.SAIU_PARA_ENTREGA.toString());
        assertEquals("ENTREGUE", Status.ENTREGUE.toString());
    }
}
