package org.zerock.b1.todo.controller.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.zerock.b1.common.annotations.JWTAuth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class TodoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod method = (HandlerMethod) handler;

        log.info("TodoInterceptor.........................");

        log.info(method);

        JWTAuth authAnnotation = method.getMethodAnnotation(JWTAuth.class);

        log.info("JWTAUTH: " + authAnnotation);

        if(authAnnotation != null){
            log.info("CHECK JWT ANNOTATION");
        }

        log.info("TodoInterceptor.........................");
        log.info("TodoInterceptor.........................");
        log.info("TodoInterceptor.........................");
        log.info("TodoInterceptor.........................");


        return true;
    }
}
