package com.tolunayoezcan.spring_boot_optimization.service;

import com.tolunayoezcan.spring_boot_optimization.dto.LecturerDTO;
import com.tolunayoezcan.spring_boot_optimization.mapper.LecturerMapper;
import com.tolunayoezcan.spring_boot_optimization.model.DegreeProgram;
import com.tolunayoezcan.spring_boot_optimization.model.Lecturer;
import com.tolunayoezcan.spring_boot_optimization.repository.DegreeProgramRepository;
import com.tolunayoezcan.spring_boot_optimization.repository.LecturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class LecturerService {

    private final LecturerRepository lecturerRepository;
    private final DegreeProgramRepository degreeProgramRepository;
    private final LecturerMapper lecturerMapper;

    public List<LecturerDTO> getAllLecturers() {
        return lecturerMapper.modelsToDto(lecturerRepository.findAll());
    }

    public LecturerDTO getLecturerById(int lecturerId) {
        return lecturerMapper.modelToDto(lecturerRepository.findById(lecturerId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Lecturer with this Id was not found")));
    }

    public LecturerDTO getLecturerByPersonnelNumber(int personnelNumber) {
        return lecturerMapper.modelToDto(lecturerRepository.findByPersonnelNumber(personnelNumber));
    }

    public List<LecturerDTO> getAllLecturersByDean(boolean isDean) {
        return lecturerMapper.modelsToDto(lecturerRepository.findByIsDean(isDean));
    }

    public List<LecturerDTO> getAllLecturersByDegreeProgramId(int degreeProgramId) {
        DegreeProgram degreeProgram = degreeProgramRepository.findById(degreeProgramId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "DegreeProgram with this Id was " +
                        "not found"));
        return lecturerMapper.modelsToDto(lecturerRepository.findByDegreeProgram(degreeProgram));
    }

    @Transactional
    public LecturerDTO createNewLecturer(LecturerDTO lecturerDTO) {
        Lecturer lecturer = lecturerMapper.dtoToModel(lecturerDTO);
        return lecturerMapper.modelToDto(lecturerRepository.save(lecturer));
    }

    @Transactional
    public LecturerDTO updateLecturer(int lecturerId, Lecturer lecturerToUpdate) {
        lecturerToUpdate.setLecturerId(lecturerId);
        lecturerToUpdate.setDegreeProgram(lecturerRepository.findById(lecturerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lecturer with this Id was not " +
                        "found"))
                .getDegreeProgram());
        return lecturerMapper.modelToDto(lecturerRepository.save(lecturerToUpdate));
    }

    public void deleteLecturer(int lecturerId) {
        if (lecturerRepository.existsById(lecturerId)) {
            lecturerRepository.deleteById(lecturerId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lecturer with this Id was not found");
        }
    }
}
