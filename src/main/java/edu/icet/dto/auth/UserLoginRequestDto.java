package edu.icet.dto.auth;

import lombok.Data;

@Data
public class UserLoginRequestDto {
    private String username;
    private String password;
}
