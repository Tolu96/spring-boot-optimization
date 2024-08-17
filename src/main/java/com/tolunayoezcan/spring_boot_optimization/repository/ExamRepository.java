package com.tolunayoezcan.spring_boot_optimization.repository;

import com.tolunayoezcan.spring_boot_optimization.model.Exam;
import com.tolunayoezcan.spring_boot_optimization.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExamRepository extends JpaRepository<Exam, UUID> {

    List<Exam> findByStudent(Student student);
    
}
