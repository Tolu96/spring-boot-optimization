package com.tolunayoezcan.spring_boot_optimization.service;

import com.tolunayoezcan.spring_boot_optimization.dto.DegreeProgramDTO;
import com.tolunayoezcan.spring_boot_optimization.enums.CampusEnum;
import com.tolunayoezcan.spring_boot_optimization.mapper.DegreeProgramMapper;
import com.tolunayoezcan.spring_boot_optimization.model.DegreeProgram;
import com.tolunayoezcan.spring_boot_optimization.model.Faculty;
import com.tolunayoezcan.spring_boot_optimization.repository.DegreeProgramRepository;
import com.tolunayoezcan.spring_boot_optimization.repository.FacultyRepository;
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

@Service
@AllArgsConstructor
public class DegreeProgramService {
    private DegreeProgramRepository degreeProgramRepository;
    private FacultyRepository facultyRepository;
    private DegreeProgramMapper degreeProgramMapper;

    @Cacheable(value = "allDegreePrograms")
    public List<DegreeProgramDTO> getAllDegreePrograms() {
        return degreeProgramMapper.modelsToDto(degreeProgramRepository.findAll());
    }

    @Cacheable(value = "degreePrograms", key = "#degreeProgramId")
    public DegreeProgramDTO getAllDegreeProgramsById(int degreeProgramId) {
        return degreeProgramMapper.modelToDto(degreeProgramRepository.findById(degreeProgramId).orElseThrow());
    }

    @Cacheable(value = "degreeProgramsByCampus", key = "#campus")
    public List<DegreeProgramDTO> getAllDegreeProgramsByCampus(CampusEnum campus) {
        return degreeProgramMapper.modelsToDto(degreeProgramRepository.findByCampus(campus));
    }

    @Cacheable(value = "degreeProgramsByFaculty", key = "#facultyId")
    public List<DegreeProgramDTO> getAllDegreeProgramsByFacultyId(int facultyId) {
        Optional<Faculty> faculty = facultyRepository.findById(facultyId);
        return degreeProgramMapper.modelsToDto(degreeProgramRepository.findByFaculty(faculty.orElseThrow()));
    }

    @Transactional
    @CachePut(value = "degreePrograms", key = "#degreeProgramDTO.degreeProgramId")
    public DegreeProgramDTO createNewDegreeProgram(DegreeProgramDTO degreeProgramDTO) {
        DegreeProgram degreeProgram = degreeProgramMapper.dtoToModel(degreeProgramDTO);
        return degreeProgramMapper.modelToDto(degreeProgramRepository.save(degreeProgram));
    }

    @Transactional
    @CachePut(value = "degreePrograms", key = "#degreeProgramId")
    public DegreeProgramDTO updateDegreeProgram(int degreeProgramId, DegreeProgram degreeProgramToUpdate) {
        degreeProgramToUpdate.setDegreeProgramId(degreeProgramId);
        degreeProgramToUpdate.setFaculty(degreeProgramRepository.findById(degreeProgramId).get().getFaculty());
        return degreeProgramMapper.modelToDto(degreeProgramRepository.save(degreeProgramToUpdate));
    }

    @CacheEvict(value = "degreePrograms", key = "#degreeProgramId")
    public void deleteDegreeProgram(int degreeProgramId) {
        if (degreeProgramRepository.existsById(degreeProgramId)) {
            degreeProgramRepository.deleteById(degreeProgramId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DegreeProgram with this Id was not found");
        }
    }

}
