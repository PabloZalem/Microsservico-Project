package br.com.zalempablo.microsservico.pagamentos.dto;

import java.math.BigDecimal;

import br.com.zalempablo.microsservico.pagamentos.model.Status;


public class PagamentoDTO {
	private Long id;
	private BigDecimal valor;
	private String nome;
	private String numero;
	private String expiracao;
	private String codigo;
	private Status status;
	private Long formaDePagamentoId;
	private Long pedidoId;
	public PagamentoDTO(Long id, BigDecimal valor, String nome, String numero, String expiracao, String codigo,
			Status status, Long formaDePagamentoId, Long pedidoId) {
		super();
		this.id = id;
		this.valor = valor;
		this.nome = nome;
		this.numero = numero;
		this.expiracao = expiracao;
		this.codigo = codigo;
		this.status = status;
		this.formaDePagamentoId = formaDePagamentoId;
		this.pedidoId = pedidoId;
	}
	
	public PagamentoDTO() {
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getExpiracao() {
		return expiracao;
	}
	public void setExpiracao(String expiracao) {
		this.expiracao = expiracao;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Long getFormaDePagamentoId() {
		return formaDePagamentoId;
	}
	public void setFormaDePagamentoId(Long formaDePagamentoId) {
		this.formaDePagamentoId = formaDePagamentoId;
	}
	public Long getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}
}
