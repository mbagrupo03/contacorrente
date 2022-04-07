package com.microservices.grupo3.contacorrente.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ContaIdExistenteBadRequestException extends RuntimeException {

    public ContaIdExistenteBadRequestException(String msg) { super(msg); }
}
