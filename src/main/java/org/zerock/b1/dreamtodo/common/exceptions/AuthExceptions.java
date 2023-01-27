package org.zerock.b1.dreamtodo.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.zerock.b1.dreamtodo.common.enums.ErrorEnum;

@Getter
public class AuthExceptions extends RuntimeException{
    ErrorEnum errorEnum;

    public AuthExceptions(ErrorEnum error){
        super(error.name());
        this.errorEnum = error;
    }
}
