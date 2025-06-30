package edu.icet.controller;

import edu.icet.dto.application.ApplicationResponseDto;
import edu.icet.dto.internship.InternshipPostRequestDto;
import edu.icet.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/internships")
    public ResponseEntity<String> postInternship(@RequestBody InternshipPostRequestDto request,
                                                 @AuthenticationPrincipal User user) {
        companyService.createInternship(request, user.getUsername());
        return ResponseEntity.ok("Internship posted successfully!");
    }

    @GetMapping("/internships/applicants/{postId}")
    public ResponseEntity<List<ApplicationResponseDto>> getApplicants(@PathVariable Long postId) {
        List<ApplicationResponseDto> applicants = companyService.getApplicantsForPost(postId);
        return ResponseEntity.ok(applicants);
    }
}
