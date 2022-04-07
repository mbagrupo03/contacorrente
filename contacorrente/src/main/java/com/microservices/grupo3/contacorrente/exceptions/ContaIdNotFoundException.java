package com.microservices.grupo3.contacorrente.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContaIdNotFoundException extends RuntimeException {

    public ContaIdNotFoundException(String msg) { super(msg); }
}
