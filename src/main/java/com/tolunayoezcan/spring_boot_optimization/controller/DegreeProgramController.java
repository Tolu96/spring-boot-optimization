package com.tolunayoezcan.spring_boot_optimization.controller;


import com.tolunayoezcan.spring_boot_optimization.dto.DegreeProgramDTO;
import com.tolunayoezcan.spring_boot_optimization.enums.CampusEnum;
import com.tolunayoezcan.spring_boot_optimization.model.DegreeProgram;
import com.tolunayoezcan.spring_boot_optimization.service.DegreeProgramService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/degreeProgram")
public class DegreeProgramController {
    private DegreeProgramService degreeProgramService;

    @GetMapping
    private ResponseEntity<List<DegreeProgramDTO>> getAllDegreePrograms() {
        return ResponseEntity.ok().body(degreeProgramService.getAllDegreePrograms());
    }

    @GetMapping("{degreeProgramId}")
    private ResponseEntity<DegreeProgramDTO> getAllDegreeProgramsById(@PathVariable("degreeProgramId") int degreeProgramId) {
        return ResponseEntity.ok().body(degreeProgramService.getAllDegreeProgramsById(degreeProgramId));
    }

    @GetMapping("findByCampus/{campus}")
    private ResponseEntity<List<DegreeProgramDTO>> getAllDegreeProgramsBySemesterHours(@PathVariable("campus") CampusEnum campus) {
        return ResponseEntity.ok().body(degreeProgramService.getAllDegreeProgramsByCampus(campus));
    }


    @GetMapping("findByFaculty/{facultyId}")
    private ResponseEntity<List<DegreeProgramDTO>> getAllDegreeProgramsByDegreeProgramType(@PathVariable("facultyId") int facultyId) {
        return ResponseEntity.ok().body(degreeProgramService.getAllDegreeProgramsByFacultyId(facultyId));
    }

    @PostMapping(value = "/", produces = "application/json")
    private ResponseEntity<DegreeProgramDTO> createNewDegreeProgram(@RequestBody DegreeProgramDTO newDegreeProgramDto) {
        return new ResponseEntity<>(degreeProgramService.createNewDegreeProgram(newDegreeProgramDto),
                HttpStatus.CREATED);
    }

    @PutMapping(path = "{degreeProgramId}")
    private ResponseEntity<DegreeProgramDTO> updateDegreeProgram(@PathVariable("degreeProgramId") int degreeProgramId
            , @RequestBody DegreeProgram degreeProgram) {
        DegreeProgramDTO updatedDegreeProgram = degreeProgramService.updateDegreeProgram(degreeProgramId,
                degreeProgram);
        return new ResponseEntity<>(updatedDegreeProgram, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "{degreeProgramId}")
    private ResponseEntity<String> deleteDegreeProgram(@PathVariable("degreeProgramId") int degreeProgramId) {
        degreeProgramService.deleteDegreeProgram(degreeProgramId);
        return new ResponseEntity<>("Degree program successfully deleted", HttpStatus.OK);
    }
}
