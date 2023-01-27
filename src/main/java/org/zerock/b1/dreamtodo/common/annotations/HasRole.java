package org.zerock.b1.dreamtodo.common.annotations;

import org.zerock.b1.dreamtodo.common.enums.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

//HasRole은 JWT에서 role을 관리하기 때문에 JWTAuth와 같이 써야한다.
public @interface HasRole {

    Role value();
}
