package com.tolunayoezcan.spring_boot_optimization.repository;

import com.tolunayoezcan.spring_boot_optimization.model.DegreeProgram;
import com.tolunayoezcan.spring_boot_optimization.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    Student findByStudentNumber(int studentNumber);

    List<Student> findBySemesterAndDegreeProgram(byte semester, DegreeProgram degreeProgram);

    List<Student> findByDegreeProgram(DegreeProgram degreeProgram);

}
