package edu.icet.dto.auth;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserRegisterRequestDto {
    private String username;
    private String email;
    private String password;
    private String role; // STUDENT, COMPANY
}