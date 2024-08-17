package com.tolunayoezcan.spring_boot_optimization.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class StudentDTO {
    UUID studentId;
    String firstName;
    String lastName;
    LocalDate birthDate;
    int studentNumber;
    short ectsPoints;
    short malusPoints;
    boolean semesterFeesPaid;
    byte semester;
    DegreeProgramDTO degreeProgram;
}
