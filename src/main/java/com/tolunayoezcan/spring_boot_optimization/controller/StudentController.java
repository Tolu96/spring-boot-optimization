package com.tolunayoezcan.spring_boot_optimization.controller;

import com.tolunayoezcan.spring_boot_optimization.dto.StudentDTO;
import com.tolunayoezcan.spring_boot_optimization.model.DegreeProgram;
import com.tolunayoezcan.spring_boot_optimization.model.Student;
import com.tolunayoezcan.spring_boot_optimization.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private StudentService studentService;

    @GetMapping
    private ResponseEntity<Page<StudentDTO>> getAllStudents(Pageable pageable) {
        Page<StudentDTO> students = studentService.getAllStudents(pageable);

        return ResponseEntity.ok().body(students);
    }

    @GetMapping("{studentId}")
    private ResponseEntity<StudentDTO> getStudentId(@PathVariable("studentId") UUID studentId) {
        return ResponseEntity.ok().body(studentService.getStudentById(studentId));
    }

    @GetMapping("findbyStudentNumber/{studentNumber}")
    private ResponseEntity<StudentDTO> getAllStudentsBySemesterHours(@PathVariable("studentNumber") int studentNumber) {
        return ResponseEntity.ok().body(studentService.getStudentByStudentNumber(studentNumber));
    }

    @GetMapping("findbyDegreeProgram/{degreeProgram}")
    private ResponseEntity<List<StudentDTO>> getAllStudentsByDegreeProgram(@PathVariable("degreeProgram") DegreeProgram degreeProgram) {
        return ResponseEntity.ok().body(studentService.getAllStudentsByDegreeProgram(degreeProgram));
    }

    @GetMapping("findbySemesterAndDegreeProgram/{semester}/{degreeProgram}")
    private ResponseEntity<List<StudentDTO>> getAllStudentsBySemeseterAndDegreeProgram(@PathVariable("semester") byte semester, @PathVariable("degreeProgram") DegreeProgram degreeProgram) {
        return ResponseEntity.ok().body(studentService.getAllStudentsBySemeseterAndDegreeProgram(semester,
                degreeProgram));
    }


    @PostMapping(value = "/", produces = "application/json")
    private ResponseEntity<StudentDTO> createNewStudent(@RequestBody StudentDTO newStudentDto) {
        return new ResponseEntity<>(studentService.createNewStudent(newStudentDto), HttpStatus.CREATED);
    }

    @PutMapping(path = "{studentId}")
    private ResponseEntity<StudentDTO> updateStudent(@PathVariable("studentId") UUID studentId,
                                                     @RequestBody Student student) {
        StudentDTO updatedStudent = studentService.updateStudent(studentId, student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "{studentId}")
    private ResponseEntity<String> deleteStudent(@PathVariable("studentId") UUID studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>("Student successfully deleted", HttpStatus.OK);
    }

}
