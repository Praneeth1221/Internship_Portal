package edu.icet.controller;


import edu.icet.dto.application.ApplicationRequestDto;
import edu.icet.dto.internship.InternshipPostResponseDto;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/internships")
    public ResponseEntity<List<InternshipPostResponseDto>> getAvailableInternships() {
        List<InternshipPostResponseDto> internships = studentService.getAvailableInternships();
        return ResponseEntity.ok(internships);
    }

    @PostMapping("/apply")
    public ResponseEntity<String> applyToInternship(@RequestBody ApplicationRequestDto request,
                                                    @AuthenticationPrincipal User user) {
        studentService.applyToInternship(request, user.getUsername());
        return ResponseEntity.ok("Application submitted successfully!");
    }
}
