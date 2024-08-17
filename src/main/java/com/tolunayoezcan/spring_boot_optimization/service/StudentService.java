package com.tolunayoezcan.spring_boot_optimization.service;

import com.tolunayoezcan.spring_boot_optimization.dto.StudentDTO;
import com.tolunayoezcan.spring_boot_optimization.mapper.StudentMapper;
import com.tolunayoezcan.spring_boot_optimization.model.DegreeProgram;
import com.tolunayoezcan.spring_boot_optimization.model.Student;
import com.tolunayoezcan.spring_boot_optimization.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<StudentDTO> getAllStudents() {
        return studentMapper.modelsToDto(studentRepository.findAll());
    }

    public StudentDTO getStudentById(UUID studentId) {
        return studentMapper.modelToDto(studentRepository.findById(studentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with this Id was not " +
                        "found")));
    }

    public StudentDTO getStudentByStudentNumber(int studentNumber) {
        return studentMapper.modelToDto(studentRepository.findByStudentNumber(studentNumber));
    }

    public List<StudentDTO> getAllStudentsBySemeseterAndDegreeProgram(byte semester, DegreeProgram degreeProgram) {
        return studentMapper.modelsToDto(studentRepository.findBySemesterAndDegreeProgram(semester, degreeProgram));
    }

    public List<StudentDTO> getAllStudentsByDegreeProgram(DegreeProgram degreeProgram) {
        return studentMapper.modelsToDto(studentRepository.findByDegreeProgram(degreeProgram));
    }

    @Transactional
    public StudentDTO createNewStudent(StudentDTO studentDTO) {
        Student student = studentMapper.dtoToModel(studentDTO);
        return studentMapper.modelToDto(studentRepository.save(student));
    }

    @Transactional
    public StudentDTO updateStudent(UUID studentId, Student studentToUpdate) {
        studentToUpdate.setStudentId(studentId);
        studentToUpdate.setDegreeProgram(studentRepository.findById(studentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with this Id was not " +
                        "found"))
                .getDegreeProgram());
        return studentMapper.modelToDto(studentRepository.save(studentToUpdate));
    }

    public void deleteStudent(UUID studentId) {
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with this Id was not found");
        }
    }

}
