package com.microservices.grupo3.contacorrente.controller.dto;

public class CriarDebitoDTO {
	
	private Integer contaId;
    private Double valorDebito;
    private Integer clienteId;
    private String tipoConta;
    
    
	public CriarDebitoDTO(Integer contaId, Double valorDebito, Integer clienteId, String tipoConta) {
		super();
		this.contaId = contaId;
		this.valorDebito = valorDebito;
		this.clienteId = clienteId;
		this.tipoConta = tipoConta;
	}


	public CriarDebitoDTO() {
		super();
	}


	
	
	public Integer getContaId() {
		return contaId;
	}


	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}


	public Double getValorDebito() {
		return valorDebito;
	}


	public void setValorDebito(Double valorDebito) {
		this.valorDebito = valorDebito;
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
