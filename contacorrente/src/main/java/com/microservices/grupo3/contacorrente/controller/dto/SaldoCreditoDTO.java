package com.microservices.grupo3.contacorrente.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaldoCreditoDTO {
	
	private Double valorCredito;

	@JsonCreator
	public SaldoCreditoDTO(@JsonProperty("saldo_credito") Double valorCredito) {
		super();
		this.valorCredito = valorCredito;
	}

	public SaldoCreditoDTO() {
		super();
	}

	public Double getValorCredito() {
		return valorCredito;
	}

	public void setValorCredito(Double valorCredito) {
		this.valorCredito = valorCredito;
	}
	
	

}
