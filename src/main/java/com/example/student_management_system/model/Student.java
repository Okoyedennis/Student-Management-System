package com.example.student_management_system.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student")

@Data
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
//    private Long studentId;
}
