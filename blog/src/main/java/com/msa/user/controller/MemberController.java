package com.msa.user.controller;

import com.msa.auth.TokenInfo;
import com.msa.post.dto.ResultDto;
import com.msa.user.domain.Member;
import com.msa.user.dto.LoginDto;
import com.msa.user.dto.SignupDto;
import com.msa.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpHeaders.SET_COOKIE;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/auth/signUp")
    public ResponseEntity<ResultDto<Member>> signUp(@RequestBody SignupDto signupDto) {
        Member newMember = memberService.addUser(signupDto.userName(), signupDto.email(), signupDto.password());

        return ResponseEntity.ok(new ResultDto<>(200, "ok", newMember));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<ResultDto<TokenInfo>> login(@RequestBody LoginDto loginDto) {
        TokenInfo tokenInfo = memberService.login(loginDto.email(), loginDto.password());

        return ResponseEntity.ok()
                .header(SET_COOKIE, generateCookie("accessToken", tokenInfo.accessToken()).toString())
                .header(SET_COOKIE, generateCookie("refreshToken", tokenInfo.refreshToken()).toString())
                .body(new ResultDto<>(200, "Success", tokenInfo));
    }

    private ResponseCookie generateCookie(String from, String token) {
        return ResponseCookie.from(from, token)
                .httpOnly(true)
                .path("/")
                .build();

    }
}
