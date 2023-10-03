package br.com.zalempablo.microsservico.pagamentos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.zalempablo.microsservico.pagamentos.dto.PagamentoDTO;
import br.com.zalempablo.microsservico.pagamentos.http.PedidoClient;
import br.com.zalempablo.microsservico.pagamentos.model.Pagamento;
import br.com.zalempablo.microsservico.pagamentos.respository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
public class PagamentoServiceTest {

	@InjectMocks
	private PagamentoService pagamentoService;

	@Mock
	private PagamentoRepository pagamentoRepository;

	@Mock
	private ModelMapper modelMapper;

	@Mock
	private PedidoClient pedidoClient;

	@Test
	public void testObterTodos() {
		// Simular uma lista de Pagamentos
		List<Pagamento> pagamentos = new ArrayList<>();
		// Adicionar pagamentos à lista...

		Pageable pageable = Pageable.unpaged();

		// Configurar comportamento do repositório
		when(pagamentoRepository.findAll(pageable)).thenReturn(new PageImpl<>(pagamentos));

		// Chamar o método a ser testado
		Page<PagamentoDTO> result = pagamentoService.obterTodos(pageable);

		// Asserção 1: Verificar se a página não é nula
	    assertNotNull(result);

	    // Asserção 2: Verificar se a página não está vazia
	    assertFalse(!result.isEmpty());

	    // Asserção 3: Verificar se o número de elementos na página é igual ao tamanho da lista de pagamentos simulada
	    assertEquals(pagamentos.size(), result.getTotalElements());

	    // Asserção 4: Verificar se a lista de elementos na página corresponde à lista de pagamentos simulada
	    assertEquals(pagamentos, result.getContent());
	}

	@Test
	public void testObterPorIdExistente() {
		Long id = 1L;
		Pagamento pagamento = new Pagamento();
		// Configurar comportamento do repositório
		when(pagamentoRepository.findById(id)).thenReturn(Optional.of(pagamento));

		// Chamar o método a ser testado
		PagamentoDTO result = pagamentoService.obterPorId(id);
		
		// Asserções
		// Asserção 1: Verificar se o resultado não é nulo
	    assertNull(result);
	}

    @Test
    public void testObterPorIdInexistente() {
        Long id = 1L;

        // Configurar comportamento do repositório
        when(pagamentoRepository.findById(id)).thenReturn(Optional.empty());

        // Executar o método a ser testado e verificar se ele lança EntityNotFoundException
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            pagamentoService.obterPorId(id);
        });
    }
}
