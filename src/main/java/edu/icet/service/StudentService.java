package edu.icet.service;



import edu.icet.dto.application.ApplicationRequestDto;
import edu.icet.dto.internship.InternshipPostResponseDto;

import java.util.List;

public interface StudentService {
    List<InternshipPostResponseDto> getAvailableInternships();
    void applyToInternship(ApplicationRequestDto request, String studentUsername);
}