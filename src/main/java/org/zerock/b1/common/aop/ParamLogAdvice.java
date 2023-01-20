package org.zerock.b1.common.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Log4j2
public class ParamLogAdvice {

    @Around("execution(* org.zerock.b1.todo.service.TodoService.*(..))")
    public Object checkTime(ProceedingJoinPoint pjp)throws Throwable {

        log.info(pjp.getArgs());

        long start = System.currentTimeMillis();

        Object result = null;

        result = pjp.proceed();

        long end = System.currentTimeMillis();

        log.info("----------------TIME----------------------");

        log.info( (end - start));

        log.info(result);

        return result;

    }


    @Before("execution(* org.zerock.b1.todo.service.TodoService.*(..))")
    public void logBefore(JoinPoint joinPoint){


        log.info("---------------------------------");
        log.info("---------------------------------");
        log.info(Arrays.toString(joinPoint.getArgs()));
        log.info("---------------------------------");
        log.info(joinPoint.getSignature());
        log.info("---------------------------------");
        log.info("---------------------------------");

    }

}
