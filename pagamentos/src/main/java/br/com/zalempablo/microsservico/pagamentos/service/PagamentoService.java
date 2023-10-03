package br.com.zalempablo.microsservico.pagamentos.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.zalempablo.microsservico.pagamentos.dto.PagamentoDTO;
import br.com.zalempablo.microsservico.pagamentos.http.PedidoClient;
import br.com.zalempablo.microsservico.pagamentos.model.Pagamento;
import br.com.zalempablo.microsservico.pagamentos.model.Status;
import br.com.zalempablo.microsservico.pagamentos.respository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PedidoClient pedidoClient;

	public Page<PagamentoDTO> obterTodos(org.springframework.data.domain.Pageable paginacao) {
		Page<Pagamento> paginatedResults = pagamentoRepository
				.findAll((org.springframework.data.domain.Pageable) paginacao);
		return paginatedResults.map(p -> modelMapper.map(p, PagamentoDTO.class));
	}

	public PagamentoDTO obterPorId(Long id) {
		Pagamento pagamento = pagamentoRepository
				.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		return modelMapper.map(pagamento, PagamentoDTO.class);
	}

	public PagamentoDTO criarPagamento(PagamentoDTO dto) {
		Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
		pagamento.setStatus(Status.CRIADO);
		pagamentoRepository.save(pagamento);

		return modelMapper.map(pagamento, PagamentoDTO.class);
	}

	public PagamentoDTO atualizarPagamento(Long id, PagamentoDTO dto) {
		Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
		pagamento.setId(id);
		pagamento = pagamentoRepository.save(pagamento);
		return modelMapper.map(pagamento, PagamentoDTO.class);
	}

	public void excluirPagamento(Long id) {
		pagamentoRepository.deleteById(id);
	}

	public void confirmarPagamento(Long id) {
		Optional<Pagamento> pagamento = pagamentoRepository.findById(id);

		if (!pagamento.isPresent()) {
			throw new EntityNotFoundException();
		}

		pagamento.get().setStatus(Status.CONFIRMADO);
		pagamentoRepository.save(pagamento.get());
		pedidoClient.atualizaPagamento(pagamento.get().getPedidoId());
	}

	public void alteraStatus(Long id) {
		Optional<Pagamento> pagamento = pagamentoRepository.findById(id);

		if (!pagamento.isPresent()) {
			throw new EntityNotFoundException();
		}

		pagamento.get().setStatus(Status.CONFIRMADO_SEM_INTEGRACAO);
		pagamentoRepository.save(pagamento.get());
		pedidoClient.atualizaPagamento(pagamento.get().getPedidoId());
	}
}

/*
 @ManyToOne
    @JoinColumn(name = "pedido_id") // Nome da coluna na tabela do banco de dados
    private PedidoClient pedido;
    */
