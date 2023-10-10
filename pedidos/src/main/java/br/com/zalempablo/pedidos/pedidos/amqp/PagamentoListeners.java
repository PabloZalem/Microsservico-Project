package br.com.zalempablo.pedidos.pedidos.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.zalempablo.pedidos.pedidos.dto.PagamentoDTO;

@Component
public class PagamentoListeners {

	@RabbitListener(queues = "pagamentos.detalhes-pedido")
    public void recebeMensagem(PagamentoDTO pagamentoDTO) {
                String mensagem = """
                Dados do pagamento: %s
                Número do pedido: %s
                Valor R$: %s
                Status: %s 
                """.formatted(pagamentoDTO.getId(),
                        pagamentoDTO.getPedidoId(),
                        pagamentoDTO.getValor(),
                        pagamentoDTO.getStatusPagamento());

        System.out.println("Recebi a mensagem " + mensagem.toString());
    }
}
