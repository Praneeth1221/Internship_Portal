package edu.icet.dto.internship;

import lombok.Data;

@Data
public class InternshipPostRequestDto {
    private String title;
    private String description;
    private String location;
    private String duration;
}
