package br.com.zalempablo.microsservico.pagamentos.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatusTest {

    @Test
    public void testEnumValues() {
        // Verifique se todos os valores da enumeração estão corretos
        assertEquals(4, Status.values().length);
        assertEquals(Status.CRIADO, Status.valueOf("CRIADO"));
        assertEquals(Status.CONFIRMADO, Status.valueOf("CONFIRMADO"));
        assertEquals(Status.CONFIRMADO_SEM_INTEGRACAO, Status.valueOf("CONFIRMADO_SEM_INTEGRACAO"));
        assertEquals(Status.CANCELADO, Status.valueOf("CANCELADO"));
    }

    @Test
    public void testEnumEquality() {
        // Verifique a igualdade de enumerações
        assertSame(Status.CRIADO, Status.CRIADO);
        assertSame(Status.CONFIRMADO, Status.CONFIRMADO);
        assertSame(Status.CONFIRMADO_SEM_INTEGRACAO, Status.CONFIRMADO_SEM_INTEGRACAO);
        assertSame(Status.CANCELADO, Status.CANCELADO);
    }

    @Test
    public void testEnumInequality() {
        // Verifique a desigualdade de enumerações
        assertNotSame(Status.CRIADO, Status.CONFIRMADO);
        assertNotSame(Status.CRIADO, Status.CONFIRMADO_SEM_INTEGRACAO);
        assertNotSame(Status.CRIADO, Status.CANCELADO);
    }
}

