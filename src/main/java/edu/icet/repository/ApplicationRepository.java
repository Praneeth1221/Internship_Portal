package edu.icet.repository;

import edu.icet.entity.ApplicationEntity;
import edu.icet.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {
    List<ApplicationEntity> findByStudentId(Long studentId);
    List<ApplicationEntity> findByPostId(Long postId);
}
