package br.com.zalempablo.pedidos.pedidos.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import br.com.zalempablo.pedidos.pedidos.dto.PedidoDto;
import br.com.zalempablo.pedidos.pedidos.model.Pedido;
import br.com.zalempablo.pedidos.pedidos.repository.PedidoRepository;

public class PedidoServiceTest {

	@InjectMocks
	private PedidoService pedidoService;

	@Mock
	private PedidoRepository pedidoRepository;

	@Mock
	private ModelMapper modelMapper;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
    public void testObterTodos() {
        // Simule o comportamento do repository e modelMapper conforme necessário
        when(pedidoRepository.findAll()).thenReturn(List.of(new Pedido(), new Pedido()));
        when(modelMapper.map(any(), eq(PedidoDto.class))).thenReturn(new PedidoDto());

        // Chame o método pedidoService.obterTodos()
        List<PedidoDto> pedidos = pedidoService.obterTodos();

        // Verifique se a lista retornada não está vazia
        assert (!pedidos.isEmpty());

        // Verifique se os objetos na lista têm os valores esperados após a conversão
        for (PedidoDto pedidoDto : pedidos) {
            // Verifique os valores esperados nos objetos PedidoDto
        }
    }

	@Test
	public void testObterPorId() {
		// Simule o comportamento do repository e modelMapper conforme necessário
		Long id = 1L;
		Pedido pedido = new Pedido();
		when(pedidoRepository.findById(id)).thenReturn(Optional.of(pedido));
		when(modelMapper.map(pedido, PedidoDto.class)).thenReturn(new PedidoDto());

		// Chame o método pedidoService.obterPorId(id)
		PedidoDto pedidoDto = pedidoService.obterPorId(id);

		// Verifique se o objeto retornado não é nulo
		assertNotNull(pedidoDto);

	}
}
