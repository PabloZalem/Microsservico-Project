package br.com.zalempablo.microsservico.pagamentos.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zalempablo.microsservico.pagamentos.dto.PagamentoDTO;
import br.com.zalempablo.microsservico.pagamentos.http.PedidoClient;
import br.com.zalempablo.microsservico.pagamentos.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
	PagamentoDTO findByPedidoId(PedidoClient pedidoId);
}