package com.microservices.grupo3.contacorrente.controller.dto;

public class CriarCreditoDTO {
	
	private Integer contaId;
    private Double valorCredito;
    private Integer clienteId;
    private String tipoConta;
    
    
	public CriarCreditoDTO(Integer contaId, Double valorCredito, Integer clienteId, String tipoConta) {
		super();
		this.contaId = contaId;
		this.valorCredito = valorCredito;
		this.clienteId = clienteId;
		this.tipoConta = tipoConta;
	}


	public CriarCreditoDTO() {
		super();
	}


	public Integer getContaId() {
		return contaId;
	}


	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}


	public Double getValorCredito() {
		return valorCredito;
	}


	public void setValorCredito(Double valorCredito) {
		this.valorCredito = valorCredito;
	}


	public Integer getClienteId() {
		return clienteId;
	}


	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}


	public String getTipoConta() {
		return tipoConta;
	}


	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
    
    
	
	

}
