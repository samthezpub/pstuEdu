<<<<<<<< HEAD:src/main/java/com/example/ptsuedu/repository/SubjectRepository.java
package com.example.ptsuedu.repository;

import com.example.ptsuedu.entity.Subject;
========
package com.example.pstuedu.repository;

import com.example.pstuedu.entity.Subject;
>>>>>>>> master:src/main/java/com/example/pstuedu/repository/SubjectRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}