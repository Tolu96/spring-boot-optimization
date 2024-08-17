package com.tolunayoezcan.spring_boot_optimization.repository;

import com.tolunayoezcan.spring_boot_optimization.enums.CourseTypeEnum;
import com.tolunayoezcan.spring_boot_optimization.model.Course;
import com.tolunayoezcan.spring_boot_optimization.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findBySemesterHours(double SemesterHours);

    List<Course> findByCourseType(CourseTypeEnum courseType);

    List<Course> findByLecturer(Lecturer lecturer);

}
