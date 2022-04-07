package com.microservices.grupo3.contacorrente.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.grupo3.contacorrente.model.ContaCorrente;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Integer> {

    Optional<ContaCorrente> findByContaId(Integer contaId);
}