package com.microservices.grupo3.contacorrente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.grupo3.contacorrente.model.ContaCorrente;
import com.microservices.grupo3.contacorrente.service.Implementacao.ContaCorrenteService;


@RestController
@RequestMapping("/conta-corrente")
public class ContaCorrenteController {
	
	@Autowired
    private final ContaCorrenteService contaCorrenteService;

	public ContaCorrenteController(ContaCorrenteService contaCorrenteService) {
        this.contaCorrenteService = contaCorrenteService;
    }
	
	
	@GetMapping(path = "/status_aplicacao")
    public String checarStatusAplicacao(){
        return "Aplicação ContaCorrente online";
    }
	
	
	 	@PostMapping
	    public ContaCorrente criarContaCorrente(@RequestBody ContaCorrente contaCorrente) {
	        return contaCorrenteService.criarContaCorrente(contaCorrente);
	    }
	 	

	    @GetMapping("/consulta/{contaId}")
	    public ContaCorrente buscarContaCorrente(@PathVariable Integer contaId) {
	        return contaCorrenteService.buscarContaCorrente(contaId);
	    }
	    
	    
	    
	    
	    @SuppressWarnings({ "unchecked", "rawtypes" })
		@DeleteMapping("{contaId}")
		public ResponseEntity deletar( @PathVariable ("contaId") Integer contaId ) {
			return contaCorrenteService.obterPorId(contaId).map(entidade -> {
				contaCorrenteService.deleteContaCorrente(entidade);
				return new ResponseEntity( HttpStatus.NO_CONTENT );
			}).orElseGet( () -> 
				new ResponseEntity("Lancamento não encontrado na base de Dados.", HttpStatus.BAD_REQUEST));
		}
	    
	    
		
}
