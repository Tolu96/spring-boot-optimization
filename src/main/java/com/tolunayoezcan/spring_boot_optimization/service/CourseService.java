package com.tolunayoezcan.spring_boot_optimization.service;

import com.tolunayoezcan.spring_boot_optimization.dto.CourseDTO;
import com.tolunayoezcan.spring_boot_optimization.enums.CourseTypeEnum;
import com.tolunayoezcan.spring_boot_optimization.mapper.CourseMapper;
import com.tolunayoezcan.spring_boot_optimization.model.Course;
import com.tolunayoezcan.spring_boot_optimization.model.Lecturer;
import com.tolunayoezcan.spring_boot_optimization.repository.CourseRepository;
import com.tolunayoezcan.spring_boot_optimization.repository.LecturerRepository;
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
public class CourseService {

    private CourseRepository courseRepository;
    private LecturerRepository lecturerRepository;
    private CourseMapper courseMapper;

    @Cacheable(value = "allCourses")
    public List<CourseDTO> getAllCourses() {
        return courseMapper.modelsToDto(courseRepository.findAll());
    }

    @Cacheable(value = "courses", key = "#courseId")
    public CourseDTO getCourseById(int courseId) {
        return courseMapper.modelToDto(courseRepository.findById(courseId).orElseThrow());
    }

    @Cacheable(value = "coursesBySemesterHours", key = "#semesterHours")
    public List<CourseDTO> getAllCoursesBySemesterHours(double semesterHours) {
        return courseMapper.modelsToDto(courseRepository.findBySemesterHours(semesterHours));
    }

    @Cacheable(value = "coursesByCourseType", key = "#courseTypeEnum")
    public List<CourseDTO> getAllCoursesByCourseType(CourseTypeEnum courseTypeEnum) {
        return courseMapper.modelsToDto(courseRepository.findByCourseType(courseTypeEnum));
    }

    @Cacheable(value = "coursesByLecturer", key = "#lecturerId")
    public List<CourseDTO> getAllCoursesByLecturer(int lecturerId) {

        Optional<Lecturer> lecturer = lecturerRepository.findById(lecturerId);

        return courseMapper.modelsToDto(courseRepository.findByLecturer(lecturer.orElseThrow()));
    }

    @Transactional
    @CachePut(value = "courses", key = "#course.courseId")
    public CourseDTO createNewCourse(CourseDTO courseDTO) {
        Course course = courseMapper.dtoToModel(courseDTO);

        return courseMapper.modelToDto(courseRepository.save(course));
    }

    @Transactional
    @CachePut(value = "courses", key = "#course.courseId")
    public CourseDTO updateCourse(int courseId, Course courseToUpdate) {
        courseToUpdate.setCourseId(courseId);
        courseToUpdate.setLecturer(courseRepository.findById(courseId).orElseThrow().getLecturer());
        return courseMapper.modelToDto(courseRepository.save(courseToUpdate));
    }

    @CacheEvict(value = "courses", key = "#courseId")
    public void deleteCourse(int courseId) {
        if (courseRepository.existsById(courseId)) {
            courseRepository.deleteById(courseId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course with this Id was not found");
        }
    }

}
