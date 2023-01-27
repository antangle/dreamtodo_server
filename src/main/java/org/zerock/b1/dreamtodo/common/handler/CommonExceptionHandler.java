package org.zerock.b1.dreamtodo.common.handler;

import io.jsonwebtoken.Jwts;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zerock.b1.dreamtodo.common.exceptions.AuthExceptions;
import org.zerock.b1.dreamtodo.common.exceptions.JWTExceptions;

import java.util.Map;

@RestControllerAdvice
@Log4j2
public class CommonExceptionHandler {
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Map<String, String>> except(HttpMediaTypeNotSupportedException exception){

        log.error("----------------------------");

        log.error(exception);

        log.error("----------------------------");

        log.error("----------------------------");

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(Map.of("exception", exception.getMessage()));

    }
    @ExceptionHandler(AuthExceptions.class)
    public ResponseEntity<Map<String, String>> AuthExceptionHandler(AuthExceptions exception) {
        return ResponseEntity.status(exception.getErrorEnum().getStatus())
                .body(Map.of("exception", exception.getErrorEnum().getMsg(), "code", Integer.toString(exception.getErrorEnum().getCode())));

    }

    @ExceptionHandler(JWTExceptions.class)
    public ResponseEntity<Map<String, String>> JWTExceptionHandler(JWTExceptions exception) {
        return ResponseEntity.status(exception.getErrorEnum().getStatus())
                .body(Map.of("exception", exception.getErrorEnum().getMsg(), "code", Integer.toString(exception.getErrorEnum().getCode())));

    }

}