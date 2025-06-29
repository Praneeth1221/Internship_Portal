package edu.icet.dto.internship;

import lombok.Data;

@Data
public class InternshipPostResponseDto {
    private Long id;
    private String title;
    private String description;
    private String location;
    private String duration;
    private String createdBy;
}
