package com.tolunayoezcan.spring_boot_optimization.controller;

import com.tolunayoezcan.spring_boot_optimization.dto.ExamDTO;
import com.tolunayoezcan.spring_boot_optimization.model.Exam;
import com.tolunayoezcan.spring_boot_optimization.service.ExamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/exam")
public class ExamController {
    private ExamService examService;

    @GetMapping
    private ResponseEntity<List<ExamDTO>> getAllExams() {
        return ResponseEntity.ok().body(examService.getAllExams());
    }

    @GetMapping("{examId}")
    private ResponseEntity<ExamDTO> getAllExamsById(@PathVariable("examId") UUID examId) {
        return ResponseEntity.ok().body(examService.getExamById(examId));
    }

    @GetMapping("findByStudent/{studentId}")
    private ResponseEntity<List<ExamDTO>> getAllExamsByStudentId(@PathVariable("studentId") UUID studentId) {
        return ResponseEntity.ok().body(examService.getAllExamsByStudentId(studentId));
    }

    @PostMapping(value = "/", produces = "application/json")
    private ResponseEntity<ExamDTO> createNewExam(@RequestBody ExamDTO newExamDto) {
        return new ResponseEntity<>(examService.createNewExam(newExamDto), HttpStatus.CREATED);
    }

    @PutMapping(path = "{examId}")
    private ResponseEntity<ExamDTO> updateExam(@PathVariable("examId") UUID examId, @RequestBody Exam exam) {
        ExamDTO updatedExam = examService.updateExam(examId, exam);
        return new ResponseEntity<>(updatedExam, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "{examId}")
    private ResponseEntity<String> deleteExam(@PathVariable("examId") UUID examId) {
        examService.deleteExam(examId);
        return new ResponseEntity<>("Degree program successfully deleted", HttpStatus.OK);
    }

}
