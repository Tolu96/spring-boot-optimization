package com.tolunayoezcan.spring_boot_optimization.dto;

import com.tolunayoezcan.spring_boot_optimization.enums.CourseTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CourseDTO {
    int courseId;
    String courseName;
    double semesterHours;
    CourseTypeEnum courseType;
    LecturerDTO lecturer;
}
