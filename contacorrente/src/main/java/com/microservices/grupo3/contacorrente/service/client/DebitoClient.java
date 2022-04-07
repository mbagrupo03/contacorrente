package com.microservices.grupo3.contacorrente.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.grupo3.contacorrente.controller.dto.CriarDebitoDTO;
import com.microservices.grupo3.contacorrente.controller.dto.SaldoDebitoDTO;

@FeignClient(name = "debito", url = "${clients.debito}")
public interface DebitoClient {

    @GetMapping(value = "/saldo/contacorrente/{contaId}")
    SaldoDebitoDTO getSaldoDebitoConta(@PathVariable("contaId") Integer contaId);

    @PostMapping()
    CriarDebitoDTO criarDebito(@RequestBody CriarDebitoDTO debitoRequest);
}
