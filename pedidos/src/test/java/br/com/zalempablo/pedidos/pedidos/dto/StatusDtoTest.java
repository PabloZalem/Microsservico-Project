package br.com.zalempablo.pedidos.pedidos.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.zalempablo.pedidos.pedidos.model.Status;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusDtoTest {

    private StatusDto statusDto;

    @BeforeEach
    public void setUp() {
        // Inicialize um objeto StatusDto antes de cada teste
        statusDto = new StatusDto(Status.CONFIRMADO);
    }

    @Test
    public void testGetStatus() {
        // Verifique se o método getStatus() retorna o valor correto
        assertEquals(Status.CONFIRMADO, statusDto.getStatus());
    }

    @Test
    public void testSetStatus() {
        // Crie um novo objeto StatusDto
        StatusDto newStatusDto = new StatusDto();

        // Defina um novo status usando o método setStatus()
        newStatusDto.setStatus(Status.ENTREGUE);

        // Verifique se o status foi definido corretamente
        assertEquals(Status.ENTREGUE, newStatusDto.getStatus());
    }
}
