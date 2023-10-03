package br.com.zalempablo.microsservico.pagamentos.dto;

import java.math.BigDecimal;

import br.com.zalempablo.microsservico.pagamentos.model.Status;

//@Getter
//@Setter
public record PagamentosDTO(
				Long id,
				BigDecimal valor,
				String nome,
				String numero,
				String expiracao,
				String codigo,
				Status status,
				Long formaDePagamentoId,
				Long pedidoId
		) {

}
