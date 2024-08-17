package com.tolunayoezcan.spring_boot_optimization.controller;

import com.tolunayoezcan.spring_boot_optimization.dto.FacultyDTO;
import com.tolunayoezcan.spring_boot_optimization.model.Faculty;
import com.tolunayoezcan.spring_boot_optimization.service.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/faculty")
public class FacultyController {
    private FacultyService facultyService;

    @GetMapping
    private ResponseEntity<List<FacultyDTO>> getAllFaculties() {
        return ResponseEntity.ok().body(facultyService.getAllFaculties());
    }

    @GetMapping("{facultyId}")
    private ResponseEntity<FacultyDTO> getAllFacultiesById(@PathVariable("facultyId") int facultyId) {
        return ResponseEntity.ok().body(facultyService.getAllFacultyById(facultyId));
    }

    @PostMapping(value = "/", produces = "application/json")
    private ResponseEntity<FacultyDTO> createNewFaculty(@RequestBody FacultyDTO newFacultyDto) {
        return new ResponseEntity<>(facultyService.createNewFaculty(newFacultyDto), HttpStatus.CREATED);
    }

    @PutMapping(path = "{facultyId}")
    private ResponseEntity<FacultyDTO> updateFaculty(@PathVariable("facultyId") int facultyId,
                                                     @RequestBody Faculty faculty) {
        FacultyDTO updatedFaculty = facultyService.updateFaculty(facultyId, faculty);
        return new ResponseEntity<>(updatedFaculty, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "{facultyId}")
    private ResponseEntity<String> deleteFaculty(@PathVariable("facultyId") int facultyId) {
        facultyService.deleteFaculty(facultyId);
        return new ResponseEntity<>("Degree program successfully deleted", HttpStatus.OK);
    }

}
