package br.com.zalempablo.pedidos.pedidos.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zalempablo.pedidos.pedidos.controller.PedidoController;
import br.com.zalempablo.pedidos.pedidos.dto.PedidoDto;
import br.com.zalempablo.pedidos.pedidos.dto.StatusDto;
import br.com.zalempablo.pedidos.pedidos.service.PedidoService;

@SpringBootTest
public class PedidoControllerTest {

	@InjectMocks
	private PedidoController controller;

	@Mock
	private PedidoService service;

	@Test
	public void testListarTodos() {
		List<PedidoDto> expectedPedidos = new ArrayList<>();
		// Preencha expectedPedidos com os dados esperados

		Mockito.when(service.obterTodos()).thenReturn(expectedPedidos);

		List<PedidoDto> result = controller.listarTodos();

		assertEquals(expectedPedidos, result);
	}

	@Test
	public void testListarPorId() {
		Long id = 1L;
		PedidoDto expectedPedido = new PedidoDto();
		// Preencha expectedPedido com os dados esperados

		Mockito.when(service.obterPorId(id)).thenReturn(expectedPedido);

		ResponseEntity<PedidoDto> result = controller.listarPorId(id);

		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(expectedPedido, result.getBody());
	}

	@Test
	public void testRealizaPedido() {
		PedidoDto pedidoDto = new PedidoDto();
		// Preencha pedidoDto com os dados necessários

		PedidoDto pedidoRealizado = new PedidoDto();
		// Preencha pedidoRealizado com os dados esperados após a criação

		Mockito.when(service.criarPedido(Mockito.any(PedidoDto.class))).thenReturn(pedidoRealizado);

		UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();
		ResponseEntity<PedidoDto> result = controller.realizaPedido(pedidoDto, uriBuilder);

		assertEquals(HttpStatus.CREATED, result.getStatusCode());
		assertEquals(pedidoRealizado, result.getBody());
	}

	@Test
	public void testAtualizaStatus() {
		Long id = 1L;
		StatusDto statusDto = new StatusDto();
		// Preencha statusDto com os dados necessários

		PedidoDto expectedPedido = new PedidoDto();
		// Preencha expectedPedido com os dados esperados após a atualização

		Mockito.when(service.atualizaStatus(id, statusDto)).thenReturn(expectedPedido);

		ResponseEntity<PedidoDto> result = controller.atualizaStatus(id, statusDto);

		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(expectedPedido, result.getBody());
	}

	@Test
	public void testAprovaPagamento() {
		Long id = 1L;

		// Simule a aprovação de pagamento pelo serviço

		ResponseEntity<Void> result = controller.aprovaPagamento(id);

		assertEquals(HttpStatus.OK, result.getStatusCode());
	}
}
