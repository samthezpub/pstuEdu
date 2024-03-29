package com.example.pstuedu.repository;

import com.example.pstuedu.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    Boolean existsGradeByHomeworkIdAndUserId(Long homework_id, Long user_id);
}
