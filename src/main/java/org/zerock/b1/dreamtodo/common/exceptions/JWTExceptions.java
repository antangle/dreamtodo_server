package org.zerock.b1.dreamtodo.common.exceptions;

import lombok.Getter;
import org.zerock.b1.dreamtodo.common.enums.ErrorEnum;

@Getter
public class JWTExceptions extends RuntimeException {
    ErrorEnum errorEnum;

    public JWTExceptions(ErrorEnum error){
        super(error.name());
        this.errorEnum = error;
    }
}
