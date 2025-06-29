package edu.icet.repository;

import edu.icet.entity.InternshipPostEntity;
import edu.icet.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InternshippostRepository extends JpaRepository<InternshipPostEntity, Long> {
    List<InternshipPostEntity> findByCreatedBy(UserEntity user);
}
