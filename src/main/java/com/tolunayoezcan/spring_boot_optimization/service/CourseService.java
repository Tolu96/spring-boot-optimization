package com.tolunayoezcan.spring_boot_optimization.service;

import com.tolunayoezcan.spring_boot_optimization.dto.CourseDTO;
import com.tolunayoezcan.spring_boot_optimization.enums.CourseTypeEnum;
import com.tolunayoezcan.spring_boot_optimization.mapper.CourseMapper;
import com.tolunayoezcan.spring_boot_optimization.model.Course;
import com.tolunayoezcan.spring_boot_optimization.model.Lecturer;
import com.tolunayoezcan.spring_boot_optimization.repository.CourseRepository;
import com.tolunayoezcan.spring_boot_optimization.repository.LecturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseService {

    private CourseRepository courseRepository;
    private LecturerRepository lecturerRepository;
    private CourseMapper courseMapper;

    public List<CourseDTO> getAllCourses() {
        return courseMapper.modelsToDto(courseRepository.findAll());
    }

    public CourseDTO getCourseById(int courseId) {
        return courseMapper.modelToDto(courseRepository.findById(courseId).orElseThrow());
    }

    public List<CourseDTO> getAllCoursesBySemesterHours(double semesterHours) {
        return courseMapper.modelsToDto(courseRepository.findBySemesterHours(semesterHours));
    }

    public List<CourseDTO> getAllCoursesByCourseType(CourseTypeEnum courseTypeEnum) {
        return courseMapper.modelsToDto(courseRepository.findByCourseType(courseTypeEnum));
    }

    public List<CourseDTO> getAllCoursesByLecturer(int lecturerId) {

        Optional<Lecturer> lecturer = lecturerRepository.findById(lecturerId);

        return courseMapper.modelsToDto(courseRepository.findByLecturer(lecturer.orElseThrow()));
    }

    @Transactional
    public CourseDTO createNewCourse(CourseDTO courseDTO) {
        Course course = courseMapper.dtoToModel(courseDTO);

        return courseMapper.modelToDto(courseRepository.save(course));
    }

    @Transactional
    public CourseDTO updateCourse(int courseId, Course courseToUpdate) {
        courseToUpdate.setCourseId(courseId);
        courseToUpdate.setLecturer(courseRepository.findById(courseId).orElseThrow().getLecturer());
        return courseMapper.modelToDto(courseRepository.save(courseToUpdate));
    }

    public void deleteCourse(int courseId) {
        if (courseRepository.existsById(courseId)) {
            courseRepository.deleteById(courseId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course with this Id was not found");
        }
    }

}
