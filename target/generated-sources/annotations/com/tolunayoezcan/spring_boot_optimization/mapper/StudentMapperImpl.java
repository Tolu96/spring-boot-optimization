package com.tolunayoezcan.spring_boot_optimization.mapper;

import com.tolunayoezcan.spring_boot_optimization.dto.DegreeProgramDTO;
import com.tolunayoezcan.spring_boot_optimization.dto.FacultyDTO;
import com.tolunayoezcan.spring_boot_optimization.dto.StudentDTO;
import com.tolunayoezcan.spring_boot_optimization.model.DegreeProgram;
import com.tolunayoezcan.spring_boot_optimization.model.Faculty;
import com.tolunayoezcan.spring_boot_optimization.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-16T15:38:21+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDTO modelToDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setStudentId( student.getStudentId() );
        studentDTO.setFirstName( student.getFirstName() );
        studentDTO.setLastName( student.getLastName() );
        studentDTO.setBirthDate( student.getBirthDate() );
        studentDTO.setStudentNumber( student.getStudentNumber() );
        studentDTO.setEctsPoints( student.getEctsPoints() );
        studentDTO.setMalusPoints( student.getMalusPoints() );
        studentDTO.setSemesterFeesPaid( student.isSemesterFeesPaid() );
        studentDTO.setSemester( student.getSemester() );
        studentDTO.setDegreeProgram( degreeProgramToDegreeProgramDTO( student.getDegreeProgram() ) );

        return studentDTO;
    }

    @Override
    public List<StudentDTO> modelsToDto(List<Student> student) {
        if ( student == null ) {
            return null;
        }

        List<StudentDTO> list = new ArrayList<StudentDTO>( student.size() );
        for ( Student student1 : student ) {
            list.add( modelToDto( student1 ) );
        }

        return list;
    }

    @Override
    public Student dtoToModel(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        Student student = new Student();

        student.setStudentId( studentDTO.getStudentId() );
        student.setFirstName( studentDTO.getFirstName() );
        student.setLastName( studentDTO.getLastName() );
        student.setBirthDate( studentDTO.getBirthDate() );
        student.setStudentNumber( studentDTO.getStudentNumber() );
        student.setEctsPoints( studentDTO.getEctsPoints() );
        student.setMalusPoints( studentDTO.getMalusPoints() );
        student.setSemesterFeesPaid( studentDTO.isSemesterFeesPaid() );
        student.setSemester( studentDTO.getSemester() );
        student.setDegreeProgram( degreeProgramDTOToDegreeProgram( studentDTO.getDegreeProgram() ) );

        return student;
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
