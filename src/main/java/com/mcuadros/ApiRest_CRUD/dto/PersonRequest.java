package com.mcuadros.ApiRest_CRUD.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequest {

    @NotBlank(message = "The id is required")
    private String firstName;
    @NotBlank(message = "The id is required")
    private String lastName;
    @NotBlank(message = "The id is required")
    @Size(min = 3, max = 3, message = "The document type must be 3 character")
    private String documentType;
    @NotBlank(message = "The id is required")
    @Size(min = 8, max = 15, message = "The document number must be between 8 and 15 characters")
    private String documentNumber;
    @Size(min = 1, max = 1, message = "The gender must be 1 character")
    private String gender;
    @NotBlank(message = "The id is required")
    @Email(message = "The email is not valid")
    private String email;
    @NotNull(message = "The birthdate is required")
    private LocalDate birthdate;
    private String phone;
    private String address;
    private String city;
    @NotBlank(message = "The id is required")
    private String country;

}
