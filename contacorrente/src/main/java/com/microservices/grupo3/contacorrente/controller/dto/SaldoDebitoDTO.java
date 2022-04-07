package com.microservices.grupo3.contacorrente.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaldoDebitoDTO {
	
	private Double valorDebito;
	

	@JsonCreator
	public SaldoDebitoDTO(@JsonProperty("saldo_debito") Double valorDebito) {
		super();
		this.valorDebito = valorDebito;
	}

	public Double getValorDebito() {
		return valorDebito;
	}

	public void setValorDebito(Double valorDebito) {
		this.valorDebito = valorDebito;
	}
	
	

}
