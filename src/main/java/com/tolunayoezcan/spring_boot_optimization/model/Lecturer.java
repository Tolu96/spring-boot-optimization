package com.tolunayoezcan.spring_boot_optimization.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "LECTURER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecturer_id")
    private int lecturerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "personnel_number")
    private int personnelNumber;

    private String email;

    private String room;

    @Column(name = "is_dean")
    private boolean isDean;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "degree_program_id", referencedColumnName = "degree_program_id")
    private DegreeProgram degreeProgram;

}
