package com.tolunayoezcan.spring_boot_optimization.model;

import com.tolunayoezcan.spring_boot_optimization.enums.CampusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "DEGREE_PROGRAM")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DegreeProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "degree_program_id")
    private int degreeProgramId;

    private String name;

    private String abbreviation;

    @Column(name = "ects_points")
    private short ectsPoints;

    private CampusEnum campus;

    @Column(name = "number_of_semester")
    private byte numberOfSemester;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id")
    private Faculty faculty;

}
