package com.tolunayoezcan.spring_boot_optimization.repository;

import com.tolunayoezcan.spring_boot_optimization.model.DegreeProgram;
import com.tolunayoezcan.spring_boot_optimization.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {

    Lecturer findByPersonnelNumber(int personnelNumber);

    List<Lecturer> findByIsDean(boolean isDean);

    List<Lecturer> findByDegreeProgram(DegreeProgram degreeProgram);

}
