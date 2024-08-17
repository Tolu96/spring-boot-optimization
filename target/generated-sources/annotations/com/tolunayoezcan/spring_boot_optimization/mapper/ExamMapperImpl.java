package com.tolunayoezcan.spring_boot_optimization.mapper;

import com.tolunayoezcan.spring_boot_optimization.dto.CourseDTO;
import com.tolunayoezcan.spring_boot_optimization.dto.DegreeProgramDTO;
import com.tolunayoezcan.spring_boot_optimization.dto.ExamDTO;
import com.tolunayoezcan.spring_boot_optimization.dto.FacultyDTO;
import com.tolunayoezcan.spring_boot_optimization.dto.LecturerDTO;
import com.tolunayoezcan.spring_boot_optimization.dto.StudentDTO;
import com.tolunayoezcan.spring_boot_optimization.model.Course;
import com.tolunayoezcan.spring_boot_optimization.model.DegreeProgram;
import com.tolunayoezcan.spring_boot_optimization.model.Exam;
import com.tolunayoezcan.spring_boot_optimization.model.Faculty;
import com.tolunayoezcan.spring_boot_optimization.model.Lecturer;
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
public class ExamMapperImpl implements ExamMapper {

    @Override
    public ExamDTO modelToDto(Exam exam) {
        if ( exam == null ) {
            return null;
        }

        ExamDTO examDTO = new ExamDTO();

        examDTO.setExamId( exam.getExamId() );
        examDTO.setStudent( studentToStudentDTO( exam.getStudent() ) );
        examDTO.setCourse( courseToCourseDTO( exam.getCourse() ) );
        examDTO.setAttempt( exam.getAttempt() );
        examDTO.setStatus( exam.getStatus() );
        examDTO.setGrade( exam.getGrade() );
        examDTO.setAnnotation( exam.getAnnotation() );

        return examDTO;
    }

    @Override
    public List<ExamDTO> modelsToDto(List<Exam> exams) {
        if ( exams == null ) {
            return null;
        }

        List<ExamDTO> list = new ArrayList<ExamDTO>( exams.size() );
        for ( Exam exam : exams ) {
            list.add( modelToDto( exam ) );
        }

        return list;
    }

    @Override
    public Exam dtoToModel(ExamDTO examDTO) {
        if ( examDTO == null ) {
            return null;
        }

        Exam exam = new Exam();

        exam.setExamId( examDTO.getExamId() );
        exam.setStudent( studentDTOToStudent( examDTO.getStudent() ) );
        exam.setCourse( courseDTOToCourse( examDTO.getCourse() ) );
        exam.setAttempt( examDTO.getAttempt() );
        exam.setStatus( examDTO.getStatus() );
        exam.setGrade( examDTO.getGrade() );
        exam.setAnnotation( examDTO.getAnnotation() );

        return exam;
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

    protected StudentDTO studentToStudentDTO(Student student) {
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

    protected LecturerDTO lecturerToLecturerDTO(Lecturer lecturer) {
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

    protected CourseDTO courseToCourseDTO(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setCourseId( course.getCourseId() );
        courseDTO.setCourseName( course.getCourseName() );
        courseDTO.setSemesterHours( course.getSemesterHours() );
        courseDTO.setCourseType( course.getCourseType() );
        courseDTO.setLecturer( lecturerToLecturerDTO( course.getLecturer() ) );

        return courseDTO;
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

    protected Student studentDTOToStudent(StudentDTO studentDTO) {
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

    protected Lecturer lecturerDTOToLecturer(LecturerDTO lecturerDTO) {
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

    protected Course courseDTOToCourse(CourseDTO courseDTO) {
        if ( courseDTO == null ) {
            return null;
        }

        Course course = new Course();

        course.setCourseId( courseDTO.getCourseId() );
        course.setCourseName( courseDTO.getCourseName() );
        course.setSemesterHours( courseDTO.getSemesterHours() );
        course.setCourseType( courseDTO.getCourseType() );
        course.setLecturer( lecturerDTOToLecturer( courseDTO.getLecturer() ) );

        return course;
    }
}
