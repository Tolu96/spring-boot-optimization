package com.tolunayoezcan.spring_boot_optimization.mapper;

import com.tolunayoezcan.spring_boot_optimization.dto.DegreeProgramDTO;
import com.tolunayoezcan.spring_boot_optimization.dto.FacultyDTO;
import com.tolunayoezcan.spring_boot_optimization.model.DegreeProgram;
import com.tolunayoezcan.spring_boot_optimization.model.Faculty;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-16T15:38:21+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class DegreeProgramMapperImpl implements DegreeProgramMapper {

    @Override
    public DegreeProgramDTO modelToDto(DegreeProgram degreeProgram) {
        if ( degreeProgram == null ) {
            return null;
        }

        DegreeProgramDTO degreeProgramDTO = new DegreeProgramDTO();

        degreeProgramDTO.setDegreeProgramId( degreeProgram.getDegreeProgramId() );
        degreeProgramDTO.setName( degreeProgram.getName() );
        degreeProgramDTO.setAbbreviation( degreeProgram.getAbbreviation() );
        degreeProgramDTO.setEctsPoints( degreeProgram.getEctsPoints() );
        degreeProgramDTO.setCampus( degreeProgram.getCampus() );
        degreeProgramDTO.setNumberOfSemester( degreeProgram.getNumberOfSemester() );
        degreeProgramDTO.setFaculty( facultyToFacultyDTO( degreeProgram.getFaculty() ) );

        return degreeProgramDTO;
    }

    @Override
    public List<DegreeProgramDTO> modelsToDto(List<DegreeProgram> degreePrograms) {
        if ( degreePrograms == null ) {
            return null;
        }

        List<DegreeProgramDTO> list = new ArrayList<DegreeProgramDTO>( degreePrograms.size() );
        for ( DegreeProgram degreeProgram : degreePrograms ) {
            list.add( modelToDto( degreeProgram ) );
        }

        return list;
    }

    @Override
    public DegreeProgram dtoToModel(DegreeProgramDTO degreeProgramDTO) {
        if ( degreeProgramDTO == null ) {
            return null;
        }

        DegreeProgram degreeProgram = new DegreeProgram();

        degreeProgram.setDegreeProgramId( degreeProgramDTO.getDegreeProgramId() );
        degreeProgram.setName( degreeProgramDTO.getName() );
        degreeProgram.setAbbreviation( degreeProgramDTO.getAbbreviation() );
        degreeProgram.setEctsPoints( degreeProgramDTO.getEctsPoints() );
        degreeProgram.setCampus( degreeProgramDTO.getCampus() );
        degreeProgram.setNumberOfSemester( degreeProgramDTO.getNumberOfSemester() );
        degreeProgram.setFaculty( facultyDTOToFaculty( degreeProgramDTO.getFaculty() ) );

        return degreeProgram;
    }

    protected FacultyDTO facultyToFacultyDTO(Faculty faculty) {
        if ( faculty == null ) {
            return null;
        }

        FacultyDTO facultyDTO = new FacultyDTO();

        facultyDTO.setFacultyId( faculty.getFacultyId() );
        facultyDTO.setName( faculty.getName() );
        facultyDTO.setAbbreviation( faculty.getAbbreviation() );

        return facultyDTO;
    }

    protected Faculty facultyDTOToFaculty(FacultyDTO facultyDTO) {
        if ( facultyDTO == null ) {
            return null;
        }

        Faculty faculty = new Faculty();

        faculty.setFacultyId( facultyDTO.getFacultyId() );
        faculty.setName( facultyDTO.getName() );
        faculty.setAbbreviation( facultyDTO.getAbbreviation() );

        return faculty;
    }
}
