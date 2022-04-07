package com.microservices.grupo3.contacorrente.service.Implementacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.grupo3.contacorrente.controller.dto.CriarCreditoDTO;
import com.microservices.grupo3.contacorrente.controller.dto.CriarDebitoDTO;
import com.microservices.grupo3.contacorrente.controller.dto.SaldoCreditoDTO;
import com.microservices.grupo3.contacorrente.exceptions.ContaIdExistenteBadRequestException;
import com.microservices.grupo3.contacorrente.exceptions.ContaIdNotFoundException;
import com.microservices.grupo3.contacorrente.model.ContaCorrente;
import com.microservices.grupo3.contacorrente.repository.ContaCorrenteRepository;
import com.microservices.grupo3.contacorrente.service.client.CreditoClient;
import com.microservices.grupo3.contacorrente.service.client.DebitoClient;

@Service
public class ContaCorrenteService {
	
	@Autowired
	private ContaCorrenteRepository repository;
	
	@Autowired
    private CreditoClient creditoClient;
    
	@Autowired
    private DebitoClient debitoClient;	
	
	
	public ContaCorrente criarContaCorrente(ContaCorrente contaCorrente) {
		
		var contaExistente = repository.findByContaId(contaCorrente.getContaId()).isPresent();

        if(contaExistente) {
            throw new ContaIdExistenteBadRequestException("ContaId " + contaCorrente.getContaId() + " já existe");
        }
        
        var credito = creditoClient.criarCredito(
                new CriarCreditoDTO(contaCorrente.getContaId(), 0.0, contaCorrente.getClienteId(), "contacorrente"));

        var debito = debitoClient.criarDebito(
                new CriarDebitoDTO(contaCorrente.getContaId(), 0.0, contaCorrente.getClienteId(), "contacorrente"));
                
		return repository.save(contaCorrente);		
		
	}
	
	
	
	public ContaCorrente atualizarSaldoContaCorrente(Integer contaId) {
		
		var contaCorrente = repository.findByContaId(contaId)
				.orElseThrow(() -> new ContaIdNotFoundException("conta nao encontrada com id: " + contaId));
		
		var credito = creditoClient.getSaldoCreditoConta(contaId);
		var debito = debitoClient.getSaldoDebitoConta(contaId);
		
		double saldoTotalConta = credito.getValorCredito() - debito.getValorDebito();
		
		contaCorrente.setSaldo(saldoTotalConta);
		
		return repository.save(contaCorrente);
		
	}
	
	
	public ContaCorrente buscarContaCorrente(Integer contaId) {
		atualizarSaldoContaCorrente(contaId);
		
		var contaCorrente = repository.findByContaId(contaId)
				.orElseThrow(() -> new ContaIdNotFoundException("conta nao encontrada com id: " + contaId));
		
		return contaCorrente;		
	}
	
	
	public Optional<ContaCorrente> obterPorId(Integer contaId) {

		return repository.findByContaId(contaId);
	}
	
	
	public void deleteContaCorrente(ContaCorrente contaCorrente) {
		
		repository.delete(contaCorrente);
				
}
	
	
	
	

}
