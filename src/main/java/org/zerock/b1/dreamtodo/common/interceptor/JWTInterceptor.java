package org.zerock.b1.dreamtodo.common.interceptor;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.zerock.b1.dreamtodo.common.annotations.HasRole;
import org.zerock.b1.dreamtodo.common.annotations.JWTAuth;
import org.zerock.b1.dreamtodo.common.enums.ErrorEnum;
import org.zerock.b1.dreamtodo.common.exceptions.JWTExceptions;
import org.zerock.b1.dreamtodo.common.exceptions.interceptor.CustomInterceptorExceptions;
import org.zerock.b1.dreamtodo.common.handler.SendResponseErrorHandler;
import org.zerock.b1.dreamtodo.common.util.JWTUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
public class JWTInterceptor implements HandlerInterceptor {

    private final JWTUtil jwtUtil;
    private String bearerExtractor(String authStr){
        if(authStr == null) return null;

        String str = authStr.substring(7);

        if(str.equals("null") || str.length() <= 4){
            return null;
        }
        return str;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //Method가 Preflight로 온다면

        if (request.getMethod().equals("OPTIONS")) {
            log.info("if request options method is options, return true");

            //패스시킴
            return true;
        }


        HandlerMethod method = (HandlerMethod) handler;

        log.info("TodoInterceptor.........................");

        //HasRole은 JWTAuth와 같이 써야한다.
        JWTAuth authAnnotation = method.getMethodAnnotation(JWTAuth.class);
        HasRole hasRole = method.getMethodAnnotation(HasRole.class);

        try{
            //JWTAuth annotation이 있는가?
            if(authAnnotation != null){
                //JWT 인증 처리
                log.info("CHECK JWT ANNOTATION");
                String authorizationStr = request.getHeader("Authorization");
                String refreshStr = request.getHeader("Refresh-Token");

                //bearer scheme 파싱
                String accessToken = this.bearerExtractor(authorizationStr);
                String refreshToken = this.bearerExtractor(refreshStr);

                log.info("here!-------------------------------------");
                log.info(accessToken);
                log.info(refreshToken);


                //토큰 인증, 실패시 안에서 핸들링
                Map access = jwtUtil.validateToken(accessToken);

                //refresh가 있다면 토큰 인증, jwt payload에 mid가 있어야함
                if(refreshToken != null && access.containsKey("mid")){
                    Map refresh = jwtUtil.validateToken(refreshToken);
                    if(access.get("mid") != refresh.get("mid")){
                        throw new CustomInterceptorExceptions(ErrorEnum.MISMATCH);
                    }
                }

                //만약 Role을 따진다면 && jwt payload에 role가 있어야함
                if(hasRole != null && access.containsKey("role")){
                    String role = access.get("role").toString();

                    //만약 명시된 role이 다르다면
                    log.info(role.equals(hasRole.value().name()));
                    if(!role.equals(hasRole.value().name())){
                        //던져
                        throw new CustomInterceptorExceptions(ErrorEnum.UNAUTHORIZED);
                    }
                }
            }

            log.info("TodoInterceptor.........................END");

            //모두 됬으면 통과
            return true;
        } catch (CustomInterceptorExceptions e) {
            SendResponseErrorHandler.sendResponseError(response, e.getErrorEnum());
            return false;
        } catch (JWTExceptions e){
            SendResponseErrorHandler.sendResponseError(response, e.getErrorEnum());
            return false;
        }
    }

}
