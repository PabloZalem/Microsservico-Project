package br.com.zalempablo.microsservico.pagamentos.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.zalempablo.microsservico.pagamentos.model.Status;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class PagamentoDTOTest {
    private PagamentoDTO pagamentoDTO;

    @BeforeEach
    public void setUp() {
        pagamentoDTO = new PagamentoDTO();
    }

    @Test
    public void testGetSetId() {
        pagamentoDTO.setId(1L);
        assertEquals(1L, pagamentoDTO.getId());
    }

    @Test
    public void testGetSetValor() {
        BigDecimal valor = new BigDecimal("100.50");
        pagamentoDTO.setValor(valor);
        assertEquals(valor, pagamentoDTO.getValor());
    }

    @Test
    public void testGetSetNome() {
        pagamentoDTO.setNome("John Doe");
        assertEquals("John Doe", pagamentoDTO.getNome());
    }

    @Test
    public void testGetSetNumero() {
        pagamentoDTO.setNumero("1234-5678-9012-3456");
        assertEquals("1234-5678-9012-3456", pagamentoDTO.getNumero());
    }

    @Test
    public void testGetSetExpiracao() {
        pagamentoDTO.setExpiracao("12/25");
        assertEquals("12/25", pagamentoDTO.getExpiracao());
    }

    @Test
    public void testGetSetCodigo() {
        pagamentoDTO.setCodigo("123");
        assertEquals("123", pagamentoDTO.getCodigo());
    }

    @Test
    public void testGetSetStatus() {
        Status status = Status.CRIADO;
        pagamentoDTO.setStatus(status);
        assertEquals(status, pagamentoDTO.getStatus());
    }

    @Test
    public void testGetSetFormaDePagamentoId() {
        pagamentoDTO.setFormaDePagamentoId(2L);
        assertEquals(2L, pagamentoDTO.getFormaDePagamentoId());
    }

    @Test
    public void testGetSetPedidoId() {
        pagamentoDTO.setPedidoId(3L);
        assertEquals(3L, pagamentoDTO.getPedidoId());
    }
}

