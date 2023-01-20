package org.zerock.b1.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.zerock.b1.common.util.JWTUtil;
import org.zerock.b1.member.dto.MemberLoginDTO;
import org.zerock.b1.member.service.MemberService;

import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TokenController {

    private final JWTUtil jwtUtil;

    private final MemberService memberService;

    @GetMapping()
    public String helloWorld(){
        return "hello world!";
    }

    @PostMapping("/api/login")
    public Map<String, String> login(MemberLoginDTO memberLoginDTO){

        long mid = memberService.checkLoginInfo(memberLoginDTO);

        Map claims = Map.of("mid", mid);

        return Map.of("access", jwtUtil.generateToken(claims, 5),
                "refresh",jwtUtil.generateToken(claims, 30)
        );

    }

    @PostMapping("/api/signin")
    public Map<String, String> signin(MemberLoginDTO memberLoginDTO){

        memberService.insertMember(memberLoginDTO);

        Map claims = Map.of("mid", 1);

        return Map.of("access", jwtUtil.generateToken(claims, 5),
                "refresh",jwtUtil.generateToken(claims, 30)
        );

    }

    @PostMapping("/api/generate")
    public Map<String, String> generate(){

        Map claims = Map.of("mid","user00");

        return Map.of("access", jwtUtil.generateToken(claims, 10),
                "refresh",jwtUtil.generateToken(claims, 10)
        );
    }

}
