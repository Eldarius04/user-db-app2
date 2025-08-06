package ru.school.userdbapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persons")
@IdClass(PersonId.class)
@Getter
@Setter
public class Person {
    @Id
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Id
    @Column(name = "surname", length = 50, nullable = false)
    private String surname;

    @Id
    @Column(nullable = false)
    private int age;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "city_of_living", length = 50)
    private String cityOfLiving;
}