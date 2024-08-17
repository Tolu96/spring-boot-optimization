package com.tolunayoezcan.spring_boot_optimization.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "STUDENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "student_id")
    private UUID studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @JsonIgnore
    @Column(name = "student_number")
    private int studentNumber;

    @Column(name = "ects_points")
    private short ectsPoints;

    @Column(name = "malus_points")
    private short malusPoints;

    @Column(name = "semester_fees_paid")
    private boolean semesterFeesPaid;

    private byte semester;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "degree_program_id", referencedColumnName = "degree_program_id")
    private DegreeProgram degreeProgram;

}
