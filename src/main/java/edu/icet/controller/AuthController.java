package edu.icet.controller;


import edu.icet.dto.auth.UserLoginRequestDto;
import edu.icet.dto.auth.UserRegisterRequestDto;
import edu.icet.dto.auth.UserResponseDto;
import edu.icet.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRegisterRequestDto request) {
        UserResponseDto response = authService.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequestDto request) {
        String token = authService.login(request);
        return ResponseEntity.ok(token);
    }
}