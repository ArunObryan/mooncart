package com.arun.ecommerce.mooncart.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@AllArgsConstructor
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception{
    private String message;
}
