package br.com.zalempablo.pedidos.pedidos.dto;

import br.com.zalempablo.pedidos.pedidos.model.Status;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class StatusDto {
	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public StatusDto(Status status) {
		super();
		this.status = status;
	}

	public StatusDto() {
	}
}
