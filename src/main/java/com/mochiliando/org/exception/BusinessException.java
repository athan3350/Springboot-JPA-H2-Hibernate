package com.mochiliando.org.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BusinessException extends RuntimeException {

    private List<ErrorModule> errors;

    public BusinessException () {}
    public BusinessException (List<ErrorModule> errors) {
        this.errors = errors;
    }
}
