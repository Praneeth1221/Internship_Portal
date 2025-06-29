package edu.icet.service;

import edu.icet.dto.auth.RegisterRequestDto;

public interface UserService {
    void registerUser(RegisterRequestDto request);
}
