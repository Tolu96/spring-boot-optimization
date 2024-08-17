package com.tolunayoezcan.spring_boot_optimization.service;

import com.tolunayoezcan.spring_boot_optimization.dto.FacultyDTO;
import com.tolunayoezcan.spring_boot_optimization.mapper.FacultyMapper;
import com.tolunayoezcan.spring_boot_optimization.model.Faculty;
import com.tolunayoezcan.spring_boot_optimization.repository.FacultyRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class FacultyService {
    private FacultyRepository facultyRepository;
    private FacultyMapper facultyMapper;

    public List<FacultyDTO> getAllFaculties() {
        return facultyMapper.modelsToDto(facultyRepository.findAll());
    }

    public FacultyDTO getAllFacultyById(int facultyId) {
        return facultyMapper.modelToDto(facultyRepository.findById(facultyId).orElseThrow());
    }

    @Transactional
    public FacultyDTO createNewFaculty(FacultyDTO facultyDTO) {
        Faculty faculty = facultyMapper.dtoToModel(facultyDTO);

        return facultyMapper.modelToDto(facultyRepository.save(faculty));
    }

    @Transactional
    public FacultyDTO updateFaculty(int facultyId, Faculty facultyToUpdate) {
        facultyToUpdate.setFacultyId(facultyId);
        return facultyMapper.modelToDto(facultyRepository.save(facultyToUpdate));
    }

    public void deleteFaculty(int facultyId) {
        if (facultyRepository.existsById(facultyId)) {
            facultyRepository.deleteById(facultyId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Faculty with this Id was not found");
        }
    }


}
