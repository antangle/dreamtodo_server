package org.zerock.b1.dreamtodo.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.b1.dreamtodo.common.util.JWTUtil;
import org.zerock.b1.dreamtodo.member.dto.MemberLoginDTO;
import org.zerock.b1.dreamtodo.member.service.MemberService;

import java.util.Map;

@RestController("/api/auth")
@Log4j2
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MemberController {
    private final JWTUtil jwtUtil;

    private final MemberService memberService;

    @GetMapping
    public String hello(){
        return "hello world";
    }
    @PostMapping("/login")
    public Map<String, String> login(MemberLoginDTO memberLoginDTO){

        return Map.of("hello", "world");
/*
        long mid = memberService.checkLoginInfo(memberLoginDTO);

        Map claims = Map.of("mid", mid);

        return Map.of("access", jwtUtil.generateToken(claims, 5),
                "refresh",jwtUtil.generateToken(claims, 30)
        );
*/

    }
}
