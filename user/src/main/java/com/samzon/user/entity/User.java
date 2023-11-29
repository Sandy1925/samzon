package com.samzon.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(nullable=true)
    private String code;
    @Column(nullable=true)
    private String name;
    @Column(nullable=true,unique=true)
    private String email;
    @Column(nullable=true)
    private String password;
    @Column(nullable=true)
    private  LocalDate dob;
    @Column(nullable=true)
    private int age;

}
