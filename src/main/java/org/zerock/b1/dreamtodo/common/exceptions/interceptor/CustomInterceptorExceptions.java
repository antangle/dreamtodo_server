package org.zerock.b1.dreamtodo.common.exceptions.interceptor;

import lombok.Getter;
import org.zerock.b1.dreamtodo.common.enums.ErrorEnum;

@Getter
public class CustomInterceptorExceptions extends RuntimeException{

    ErrorEnum errorEnum;

    public CustomInterceptorExceptions(ErrorEnum error){
        super(error.name());
        this.errorEnum = error;
    }
}
