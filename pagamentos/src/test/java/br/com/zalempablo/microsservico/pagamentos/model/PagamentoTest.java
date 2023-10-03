package br.com.zalempablo.microsservico.pagamentos.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;

public class PagamentoTest {

	private Pagamento pagamento;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		pagamento = new Pagamento();
	}

	@Test
	public void testSetAndGetId() {
		Long id = 1L;
		pagamento.setId(id);
		assertEquals(id, pagamento.getId());
	}

	@Test
	public void testSetAndGetValor() {
		BigDecimal valor = new BigDecimal("100.00");
		pagamento.setValor(valor);
		assertEquals(valor, pagamento.getValor());
	}

	@Test
	public void testSetAndGetNome() {
		String nome = "João da Silva";
		pagamento.setNome(nome);
		assertEquals(nome, pagamento.getNome());
	}

	@Test
	public void testSetAndGetNumero() {
		String numero = "1234-5678-9012-3456";
		pagamento.setNumero(numero);
		assertEquals(numero, pagamento.getNumero());
	}

	@Test
	public void testSetAndGetExpiracao() {
		String expiracao = "12/25";
		pagamento.setExpiracao(expiracao);
		assertEquals(expiracao, pagamento.getExpiracao());
	}

	@Test
	public void testSetAndGetCodigo() {
		String codigo = "123";
		pagamento.setCodigo(codigo);
		assertEquals(codigo, pagamento.getCodigo());
	}

	@Test
	public void testSetAndGetStatus() {
		Status status = Status.CONFIRMADO;
		pagamento.setStatus(status);
		assertEquals(status, pagamento.getStatus());
	}

	@Test
	public void testSetAndGetPedidoId() {
		Long pedidoId = 10L;
		pagamento.setPedidoId(pedidoId);
		assertEquals(pedidoId, pagamento.getPedidoId());
	}

	@Test
	public void testSetAndGetFormaDePagamentoId() {
		Long formaDePagamentoId = 20L;
		pagamento.setFormaDePagamentoId(formaDePagamentoId);
		assertEquals(formaDePagamentoId, pagamento.getFormaDePagamentoId());
	}

	@Test
	public void testEqualsAndHashCode() {
		Pagamento pagamento1 = new Pagamento(1L, new BigDecimal("100.00"), "João da Silva", "1234-5678-9012-3456",
				"12/25", "123", Status.CONFIRMADO, 10L, 20L);
		Pagamento pagamento2 = new Pagamento(1L, new BigDecimal("100.00"), "João da Silva", "1234-5678-9012-3456",
				"12/25", "123", Status.CRIADO, 10L, 20L);
		Pagamento pagamento3 = new Pagamento(2L, new BigDecimal("200.00"), "Maria Souza", "9876-5432-1098-7654",
				"06/24", "456", Status.CANCELADO, 5L, 15L);

		assertEquals(pagamento1, pagamento2);
		assertNotEquals(pagamento1, pagamento3);
		assertNotEquals(pagamento2, pagamento3);

		assertEquals(pagamento1.hashCode(), pagamento2.hashCode());
		assertNotEquals(pagamento1.hashCode(), pagamento3.hashCode());
		assertNotEquals(pagamento2.hashCode(), pagamento3.hashCode());
	}
}
