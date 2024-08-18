package com.spartamsa_exam.auth.controller;

import com.spartamsa_exam.auth.application.AuthService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    // 서버 포트
    @Value("${server.port}")
    private String serverPort;

    /**
     * 사용자 ID를 받아 JWT 액세스 토큰을 생성하여 응답합니다.
     *
     * @param user_id 사용자 ID
     * @return JWT 액세스 토큰을 포함한 AuthResponse 객체를 반환합니다.
     */
    @GetMapping("/auth/signIn")
    public ResponseEntity<?> createAuthenticationToken(@RequestParam String user_id) {
        String accessToken = authService.createAccessToken(user_id);
        AuthResponse authResponse = new AuthResponse(accessToken);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Server-Port", serverPort);

        return ResponseEntity.ok().headers(headers).body(authResponse);
    }

    /**
     * JWT 액세스 토큰을 포함하는 응답 객체입니다.
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class AuthResponse {
        private String access_token;

    }
}
