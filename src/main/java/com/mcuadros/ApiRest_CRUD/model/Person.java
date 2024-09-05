package com.mcuadros.ApiRest_CRUD.model;

import com.mcuadros.ApiRest_CRUD.util.Role;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "persons", schema = "public")
public class Person {

    @Id
    @Column("id")
    private Long id;
    @Column("first_name")
    private String firstName;
    @Column("last_name")
    private String lastName;
    @Column("document_type")
    private String documentType;
    @Column("document_number")
    private String documentNumber;
    @Column("gender")
    private String gender;
    @Column("role")
    private Role role;
    @Column("email")
    private String email;
    @Column("password")
    private String password;
    @Column("birthdate")
    private LocalDate birthdate;
    @Column("phone")
    private String phone;
    @Column("address")
    private String address;
    @Column("city")
    private String city;
    @Column("country")
    private String country;
    @Column("creation_date")
    private LocalDateTime creationDate=LocalDateTime.now();
    @Column("write_date")
    private LocalDateTime writeDate=LocalDateTime.now();
    @Column("state")
    private String state="A";

}
