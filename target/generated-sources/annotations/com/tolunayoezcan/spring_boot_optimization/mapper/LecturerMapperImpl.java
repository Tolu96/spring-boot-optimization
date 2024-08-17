package com.tolunayoezcan.spring_boot_optimization.mapper;

import com.tolunayoezcan.spring_boot_optimization.dto.DegreeProgramDTO;
import com.tolunayoezcan.spring_boot_optimization.dto.FacultyDTO;
import com.tolunayoezcan.spring_boot_optimization.dto.LecturerDTO;
import com.tolunayoezcan.spring_boot_optimization.model.DegreeProgram;
import com.tolunayoezcan.spring_boot_optimization.model.Faculty;
import com.tolunayoezcan.spring_boot_optimization.model.Lecturer;
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
public class LecturerMapperImpl implements LecturerMapper {

    @Override
    public LecturerDTO modelToDto(Lecturer lecturer) {
        if ( lecturer == null ) {
            return null;
        }

        LecturerDTO lecturerDTO = new LecturerDTO();

        lecturerDTO.setLecturerId( lecturer.getLecturerId() );
        lecturerDTO.setFirstName( lecturer.getFirstName() );
        lecturerDTO.setLastName( lecturer.getLastName() );
        lecturerDTO.setPersonnelNumber( lecturer.getPersonnelNumber() );
        lecturerDTO.setEmail( lecturer.getEmail() );
        lecturerDTO.setRoom( lecturer.getRoom() );
        lecturerDTO.setDean( lecturer.isDean() );
        lecturerDTO.setDegreeProgram( degreeProgramToDegreeProgramDTO( lecturer.getDegreeProgram() ) );

        return lecturerDTO;
    }

    @Override
    public List<LecturerDTO> modelsToDto(List<Lecturer> lecturer) {
        if ( lecturer == null ) {
            return null;
        }

        List<LecturerDTO> list = new ArrayList<LecturerDTO>( lecturer.size() );
        for ( Lecturer lecturer1 : lecturer ) {
            list.add( modelToDto( lecturer1 ) );
        }

        return list;
    }

    @Override
    public Lecturer dtoToModel(LecturerDTO lecturerDTO) {
        if ( lecturerDTO == null ) {
            return null;
        }

        Lecturer lecturer = new Lecturer();

        lecturer.setLecturerId( lecturerDTO.getLecturerId() );
        lecturer.setFirstName( lecturerDTO.getFirstName() );
        lecturer.setLastName( lecturerDTO.getLastName() );
        lecturer.setPersonnelNumber( lecturerDTO.getPersonnelNumber() );
        lecturer.setEmail( lecturerDTO.getEmail() );
        lecturer.setRoom( lecturerDTO.getRoom() );
        lecturer.setDean( lecturerDTO.isDean() );
        lecturer.setDegreeProgram( degreeProgramDTOToDegreeProgram( lecturerDTO.getDegreeProgram() ) );

        return lecturer;
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

    protected DegreeProgramDTO degreeProgramToDegreeProgramDTO(DegreeProgram degreeProgram) {
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

    protected DegreeProgram degreeProgramDTOToDegreeProgram(DegreeProgramDTO degreeProgramDTO) {
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
}
