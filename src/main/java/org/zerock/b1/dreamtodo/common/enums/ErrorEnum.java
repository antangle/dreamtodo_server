package org.zerock.b1.dreamtodo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public enum ErrorEnum {

    //AuthExceptions
    NO_USER(401,"no user exists in database", 2011),
    PASSWORD_MISMATCH(403, "user or password mismatch", 2012),

    //AccessToken Exceptions
    UNACCEPT(401,"Token is null or too short", 2021),
    BADTYPE(401, "Token type Bearer", 2022),
    MALFORM(403, "Malformed Token", 2023),
    BADSIGN(403, "BadSignatured Token", 2024),
    EXPIRED(403, "Expired Token", 2025),
    MISMATCH(403, "Mismatching Tokens", 2026),
    ACCESS_ALIVE(403, "Access Token should be expired", 2027),

    WRONG(403, "WRONG!!", 2028),

    //RoleExceptions
    UNAUTHORIZED(401,"unauthorized role", 2031);

    int code;

    int status;

    String msg;

    ErrorEnum(int status, String msg, int code){
        this.status = status;
        this.msg = msg;
        this.code = code;
    }

}
