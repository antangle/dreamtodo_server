package org.zerock.b1.dreamtodo.common.handler;

import com.google.gson.Gson;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.zerock.b1.dreamtodo.common.enums.ErrorEnum;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@NoArgsConstructor
public class SendResponseErrorHandler {

    public static void sendResponseError(HttpServletResponse response, ErrorEnum error){

        response.setStatus(error.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        Gson gson = new Gson();

        String responseStr = gson.toJson(Map.of("msg", error.getMsg(), "time", new Date(), "code", error.getCode()));

        try {
            response.getWriter().println(responseStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
