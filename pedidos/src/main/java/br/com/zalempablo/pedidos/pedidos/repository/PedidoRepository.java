package br.com.zalempablo.pedidos.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.zalempablo.pedidos.pedidos.model.Pedido;
import br.com.zalempablo.pedidos.pedidos.model.Status;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Pedido p set p.status = :status where p = :pedidoId")
    void atualizaStatus(Status status, Pedido pedidoId);

    @Query(value = "SELECT p from Pedido p LEFT JOIN FETCH p.itens where p.id = :id")
    Pedido porIdComItens(Long id);


}
