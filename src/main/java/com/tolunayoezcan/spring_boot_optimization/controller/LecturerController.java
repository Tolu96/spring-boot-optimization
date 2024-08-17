package com.tolunayoezcan.spring_boot_optimization.controller;

import com.tolunayoezcan.spring_boot_optimization.dto.LecturerDTO;
import com.tolunayoezcan.spring_boot_optimization.model.Lecturer;
import com.tolunayoezcan.spring_boot_optimization.service.LecturerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/lecturer")
public class LecturerController {
    private LecturerService lecturerService;

    @GetMapping
    private ResponseEntity<List<LecturerDTO>> getAllLecturers() {
        return ResponseEntity.ok().body(lecturerService.getAllLecturers());
    }

    @GetMapping("{lecturerId}")
    private ResponseEntity<LecturerDTO> getLecturerById(@PathVariable("lecturerId") int lecturerId) {
        return ResponseEntity.ok().body(lecturerService.getLecturerById(lecturerId));
    }

    @GetMapping("findByPersonnelNumber/{personnelNumber}")
    private ResponseEntity<LecturerDTO> getLecturerByPersonnelNumber(@PathVariable("personnelNumber") int personnelNumber) {
        return ResponseEntity.ok().body(lecturerService.getLecturerByPersonnelNumber(personnelNumber));
    }

    @GetMapping("findByDean/{isDean}")
    private ResponseEntity<List<LecturerDTO>> getAllLecturersByPersonnelNumber(@PathVariable("isDean") boolean isDean) {
        return ResponseEntity.ok().body(lecturerService.getAllLecturersByDean(isDean));
    }

    @GetMapping("findByDegreeProgram/{degreeProgramId}")
    private ResponseEntity<List<LecturerDTO>> getAllLecturersByDegreeProgramId(@PathVariable("degreeProgramId") int degreeProgramId) {
        return ResponseEntity.ok().body(lecturerService.getAllLecturersByDegreeProgramId(degreeProgramId));
    }


    @PostMapping(value = "/", produces = "application/json")
    private ResponseEntity<LecturerDTO> createNewLecturer(@RequestBody LecturerDTO newLecturerDto) {
        return new ResponseEntity<>(lecturerService.createNewLecturer(newLecturerDto), HttpStatus.CREATED);
    }

    @PutMapping(path = "{lecturerId}")
    private ResponseEntity<LecturerDTO> updateLecturer(@PathVariable("lecturerId") int lecturerId,
                                                       @RequestBody Lecturer lecturer) {
        LecturerDTO updatedLecturer = lecturerService.updateLecturer(lecturerId, lecturer);
        return new ResponseEntity<>(updatedLecturer, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "{lecturerId}")
    private ResponseEntity<String> deleteLecturer(@PathVariable("lecturerId") int lecturerId) {
        lecturerService.deleteLecturer(lecturerId);
        return new ResponseEntity<>("Degree program successfully deleted", HttpStatus.OK);
    }

}
