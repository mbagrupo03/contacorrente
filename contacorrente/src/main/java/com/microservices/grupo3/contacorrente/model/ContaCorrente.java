package com.microservices.grupo3.contacorrente.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacorrente")
public class ContaCorrente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cc;

	private Integer contaId;

	private double saldo;
	
	private Integer clienteId;

	

	public ContaCorrente(Long id_cc, Integer contaId, double saldo, Integer clienteId) {
		super();
		this.id_cc = id_cc;
		this.contaId = contaId;
		this.saldo = saldo;
		this.clienteId = clienteId;
	}
	
	

	public ContaCorrente() {
		super();
	}

	public Long getId() {
		return id_cc;
	}

	public void setId(Long id_cc) {
		this.id_cc = id_cc;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public Integer getContaId() {
		return contaId;
	}

	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}


	public Integer getClienteId() {
		return clienteId;
	}


	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}




}
