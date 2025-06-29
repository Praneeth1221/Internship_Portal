package edu.icet.dto.application;

import lombok.Data;

@Data
public class ApplicationResponseDto {
    private Long id;
    private Long postId;
    private String postTitle;
    private Long studentId;
    private String studentUsername;
    private String status; // e.g., APPLIED, SELECTED, REJECTED
    private String resumeLink;
}

