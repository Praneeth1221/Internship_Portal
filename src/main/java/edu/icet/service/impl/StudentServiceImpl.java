package edu.icet.service.impl;


import edu.icet.dto.application.ApplicationRequestDto;
import edu.icet.dto.internship.InternshipPostResponseDto;
import edu.icet.entity.ApplicationEntity;
import edu.icet.entity.InternshipPostEntity;
import edu.icet.entity.UserEntity;
import edu.icet.repository.ApplicationRepository;
import edu.icet.repository.InternshippostRepository;
import edu.icet.repository.UserRepository;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final InternshippostRepository internshipPostRepository;
    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    @Override
    public List<InternshipPostResponseDto> getAvailableInternships() {
        List<InternshipPostEntity> posts = internshipPostRepository.findAll();
        return posts.stream().map(this::mapToResponseDto).collect(Collectors.toList());
    }

    @Override
    public void applyToInternship(ApplicationRequestDto request, String studentUsername) {
        UserEntity student = userRepository.findByUsername(studentUsername)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        ApplicationEntity application = new ApplicationEntity();
        application.setStudentId(student.getId());
        application.setPostId(request.getPostId());
        application.setStatus("PENDING");
        application.setResumeLink(request.getResumeLink());

        applicationRepository.save(application);
    }

    private InternshipPostResponseDto mapToResponseDto(InternshipPostEntity post) {
        InternshipPostResponseDto dto = new InternshipPostResponseDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setLocation(post.getLocation());
        dto.setDuration(post.getDuration());
        dto.setCreatedBy(post.getCreatedBy());
        return dto;
    }
}