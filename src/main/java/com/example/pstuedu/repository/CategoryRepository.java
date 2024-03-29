package com.example.pstuedu.repository;

import com.example.pstuedu.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Subject, Long> {
}
