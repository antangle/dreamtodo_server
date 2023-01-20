package org.zerock.b1.common.controller.exceptions;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private int code;
    private String msg;

    public CustomException(int code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
