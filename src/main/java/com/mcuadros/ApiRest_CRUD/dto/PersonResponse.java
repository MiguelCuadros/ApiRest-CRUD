package com.mcuadros.ApiRest_CRUD.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponse {

    private String firstName;
    private String lastName;
    private String documentType;
    private String documentNumber;
    private String gender;
    private String email;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthdate;
    private String phone;
    private String address;
    private String city;
    private String country;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime creationDate;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime writeDate;

}
