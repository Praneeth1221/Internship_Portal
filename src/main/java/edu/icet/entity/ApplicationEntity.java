package edu.icet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserEntity student;

    @ManyToOne
    private InternshipPostEntity internshipPost;

    private String status; // e.g., PENDING, ACCEPTED
    private String resumeLink;
}
