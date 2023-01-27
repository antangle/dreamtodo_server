package org.zerock.b1.dreamtodo.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.zerock.b1.dreamtodo.common.annotations.HasRole;
import org.zerock.b1.dreamtodo.common.annotations.JWTAuth;
import org.zerock.b1.dreamtodo.common.enums.ErrorEnum;
import org.zerock.b1.dreamtodo.common.enums.Role;
import org.zerock.b1.dreamtodo.common.exceptions.JWTExceptions;
import org.zerock.b1.dreamtodo.common.util.JWTUtil;
import org.zerock.b1.dreamtodo.member.dto.MemberDTO;
import org.zerock.b1.dreamtodo.member.dto.MemberLoginDTO;
import org.zerock.b1.dreamtodo.member.dto.RefreshTokenDTO;
import org.zerock.b1.dreamtodo.member.service.MemberService;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@Log4j2
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MemberController {
    private final JWTUtil jwtUtil;

    private final MemberService memberService;

    @JWTAuth
    @HasRole(value = Role.ADMIN)
    @GetMapping("/temp")
    public String hello(){
        return "hello world";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody MemberLoginDTO memberLoginDTO){
        log.info(memberLoginDTO);
        MemberDTO memberDTO = memberService.checkLoginInfo(memberLoginDTO);
        log.info(memberDTO);
        Map claims = Map.of("mid", memberDTO.getMid(), "role", memberDTO.getRole());

        return Map.of("access", jwtUtil.generateToken(claims, 5),
                "refresh",jwtUtil.generateToken(claims, 30)
        );
    }

    @PostMapping("/refresh")
    public Map<String, String> refresh(@RequestBody RefreshTokenDTO refreshTokenDTO){

        log.info(refreshTokenDTO);
        log.info("refresh-----------------------------------");
        Map refreshClaims = jwtUtil.validateToken(refreshTokenDTO.getRefresh());

        return Map.of("access", jwtUtil.generateToken(refreshClaims, 5),
                "refresh",jwtUtil.generateToken(refreshClaims, 30)
        );
    }

    @PostMapping("/signup")
    public String signup(@RequestBody MemberLoginDTO memberLoginDTO){
        memberService.insertMember(memberLoginDTO);
        return null;
    }
}
