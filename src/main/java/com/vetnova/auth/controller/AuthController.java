package com.vetnova.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetnova.auth.dto.AuthResponse;
import com.vetnova.auth.dto.LoginRequest;
import com.vetnova.auth.dto.RegistroRequest;
import com.vetnova.auth.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestBody RegistroRequest request) {
        String mensaje = authService.registrarUsuario(request);
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}
