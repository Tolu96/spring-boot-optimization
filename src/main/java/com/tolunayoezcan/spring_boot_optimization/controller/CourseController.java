package com.tolunayoezcan.spring_boot_optimization.controller;

import com.tolunayoezcan.spring_boot_optimization.dto.CourseDTO;
import com.tolunayoezcan.spring_boot_optimization.enums.CourseTypeEnum;
import com.tolunayoezcan.spring_boot_optimization.model.Course;
import com.tolunayoezcan.spring_boot_optimization.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {
    private CourseService courseService;

    @GetMapping
    private ResponseEntity<List<CourseDTO>> getAllCourses() {
        return ResponseEntity.ok().body(courseService.getAllCourses());
    }

    @GetMapping("{courseId}")
    private ResponseEntity<CourseDTO> getCourseById(@PathVariable("courseId") int courseId) {
        return ResponseEntity.ok().body(courseService.getCourseById(courseId));
    }

    @GetMapping("findbySemesterHours/{semesterHours}")
    private ResponseEntity<List<CourseDTO>> getAllCoursesBySemesterHours(@PathVariable("semesterHours") double semesterHours) {
        return ResponseEntity.ok().body(courseService.getAllCoursesBySemesterHours(semesterHours));
    }


    @GetMapping("findByCourseType/{courseType}")
    private ResponseEntity<List<CourseDTO>> getAllCoursesByCourseType(@PathVariable("courseType") CourseTypeEnum courseType) {
        return ResponseEntity.ok().body(courseService.getAllCoursesByCourseType(courseType));
    }


    @GetMapping("findbyLecturer/{lecturerId}")
    private ResponseEntity<List<CourseDTO>> getAllCoursesByLecturer(@PathVariable("lecturerId") int lecturerId) {
        return ResponseEntity.ok().body(courseService.getAllCoursesByLecturer(lecturerId));
    }

    @PostMapping(value = "/", produces = "application/json")
    private ResponseEntity<CourseDTO> createNewCourse(@RequestBody CourseDTO newCourseDto) {
        return new ResponseEntity<>(courseService.createNewCourse(newCourseDto), HttpStatus.CREATED);
    }

    @PutMapping(path = "{courseId}")
    private ResponseEntity<CourseDTO> updateCourse(@PathVariable("courseId") int courseId, @RequestBody Course course) {
        CourseDTO updatedCourse = courseService.updateCourse(courseId, course);
        return new ResponseEntity<>(updatedCourse, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "{courseId}")
    private ResponseEntity<String> deleteCourse(@PathVariable("courseId") int courseId) {
        courseService.deleteCourse(courseId);
        return new ResponseEntity<>("Course successfully deleted", HttpStatus.OK);
    }
}
