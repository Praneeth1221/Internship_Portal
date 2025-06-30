package edu.icet.service;


import edu.icet.dto.application.ApplicationResponseDto;
import edu.icet.dto.internship.InternshipPostRequestDto;

import java.util.List;

public interface CompanyService {
    void createInternship(InternshipPostRequestDto request, String companyUsername);
    List<ApplicationResponseDto> getApplicantsForPost(Long postId);
}
