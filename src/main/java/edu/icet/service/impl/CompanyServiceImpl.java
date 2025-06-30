package edu.icet.service.impl;

import edu.icet.dto.application.ApplicationResponseDto;
import edu.icet.dto.internship.InternshipPostRequestDto;
import edu.icet.entity.ApplicationEntity;
import edu.icet.entity.InternshipPostEntity;
import edu.icet.entity.UserEntity;
import edu.icet.repository.ApplicationRepository;
import edu.icet.repository.InternshippostRepository;
import edu.icet.repository.UserRepository;
import edu.icet.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final InternshippostRepository internshipPostRepository;
    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    @Override
    public void createInternship(InternshipPostRequestDto request, String companyUsername) {
        UserEntity company = userRepository.findByUsername(companyUsername)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        InternshipPostEntity post = new InternshipPostEntity();
        post.setTitle(request.getTitle());
        post.setDescription(request.getDescription());
        post.setLocation(request.getLocation());
        post.setDuration(request.getDuration());
        post.setCreatedBy(company.getUsername());

        internshipPostRepository.save(post);
    }

    @Override
    public List<ApplicationResponseDto> getApplicantsForPost(Long postId) {
        List<ApplicationEntity> applications = applicationRepository.findByPostId(postId);
        return applications.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private ApplicationResponseDto mapToDto(ApplicationEntity app) {
        ApplicationResponseDto dto = new ApplicationResponseDto();
        dto.setId(app.getId());
        dto.setStudentId(app.getStudentId());
        dto.setPostId(app.getPostId());
        dto.setStatus(app.getStatus());
        dto.setResumeLink(app.getResumeLink());
        return dto;
    }
}
