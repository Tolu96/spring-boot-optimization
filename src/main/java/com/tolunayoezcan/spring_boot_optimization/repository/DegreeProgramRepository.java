package com.tolunayoezcan.spring_boot_optimization.repository;

import com.tolunayoezcan.spring_boot_optimization.enums.CampusEnum;
import com.tolunayoezcan.spring_boot_optimization.model.DegreeProgram;
import com.tolunayoezcan.spring_boot_optimization.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DegreeProgramRepository extends JpaRepository<DegreeProgram, Integer> {

    List<DegreeProgram> findByCampus(CampusEnum campus);

    List<DegreeProgram> findByFaculty(Faculty faculty);

}
