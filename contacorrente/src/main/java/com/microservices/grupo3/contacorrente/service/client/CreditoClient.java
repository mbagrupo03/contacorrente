package com.microservices.grupo3.contacorrente.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.grupo3.contacorrente.controller.dto.CriarCreditoDTO;
import com.microservices.grupo3.contacorrente.controller.dto.SaldoCreditoDTO;

@FeignClient(name = "credito", url = "${clients.credito}")
public interface CreditoClient {

    @GetMapping(value = "/saldo/contacorrente/{contaId}")
    SaldoCreditoDTO getSaldoCreditoConta(@PathVariable Integer contaId);

    @PostMapping()
    CriarCreditoDTO criarCredito(@RequestBody CriarCreditoDTO creditoRequest);
}