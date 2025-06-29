package edu.icet.service;


import edu.icet.dto.auth.UserLoginRequestDto;
import edu.icet.dto.auth.UserRegisterRequestDto;
import edu.icet.dto.auth.UserResponseDto;

public interface AuthService {
    UserResponseDto register(UserRegisterRequestDto request);
    String login(UserLoginRequestDto request);
}
