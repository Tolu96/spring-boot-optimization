package com.tolunayoezcan.spring_boot_optimization.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tolunayoezcan.spring_boot_optimization.enums.AnnotationEnum;
import com.tolunayoezcan.spring_boot_optimization.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "EXAM")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "exam_id")
    private UUID examId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;

    private byte attempt;

    @JsonIgnore
    private StatusEnum status;

    private double grade;

    private AnnotationEnum annotation;

}
