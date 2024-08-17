package com.tolunayoezcan.spring_boot_optimization.service;

import com.tolunayoezcan.spring_boot_optimization.dto.ExamDTO;
import com.tolunayoezcan.spring_boot_optimization.enums.StatusEnum;
import com.tolunayoezcan.spring_boot_optimization.mapper.ExamMapper;
import com.tolunayoezcan.spring_boot_optimization.model.Exam;
import com.tolunayoezcan.spring_boot_optimization.model.Student;
import com.tolunayoezcan.spring_boot_optimization.repository.ExamRepository;
import com.tolunayoezcan.spring_boot_optimization.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ExamService {
    private ExamRepository examRepository;
    private StudentRepository studentRepository;
    private ExamMapper examMapper;

    @Cacheable(value = "allExams")
    public List<ExamDTO> getAllExams() {
        return examMapper.modelsToDto(examRepository.findAll());
    }

    @Cacheable(value = "exams", key = "#examId")
    public ExamDTO getExamById(UUID examId) {
        return examMapper.modelToDto(examRepository.findById(examId).orElseThrow());
    }


    @Cacheable(value = "examsByStudent", key = "#studentId")
    public List<ExamDTO> getAllExamsByStudentId(UUID studentId) {

        Optional<Student> student = studentRepository.findById(studentId);

        return examMapper.modelsToDto(examRepository.findByStudent(student.orElseThrow()));
    }

    @Transactional
    @CachePut(value = "exams", key = "#exam.examId")
    public ExamDTO createNewExam(ExamDTO examDTO) {
        Exam exam = examMapper.dtoToModel(examDTO);
        exam.setStatus(StatusEnum.AN);
        exam.setAttempt((byte) 1);

        if (exam.getGrade() > 4.0) {
            exam.setStatus(StatusEnum.NB);
        } else if (exam.getGrade() <= 4.0) {
            exam.setStatus(StatusEnum.BE);
        }

        return examMapper.modelToDto(examRepository.save(exam));
    }

    @Transactional
    @CachePut(value = "exams", key = "#exam.examId")
    public ExamDTO updateExam(UUID examId, Exam examToUpdate) {
        Student student = studentRepository.findById(examToUpdate.getStudent().getStudentId()).orElseThrow();
        examToUpdate.setExamId(examId);
        examToUpdate.setStudent(student);
        return examMapper.modelToDto(examRepository.save(examToUpdate));
    }

    @CacheEvict(value = "exams", key = "#examId")
    public void deleteExam(UUID examId) {
        if (examRepository.existsById(examId)) {
            examRepository.deleteById(examId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exam with this Id was not found");
        }
    }

}
