package com.mcuadros.ApiRest_CRUD.controller;

import com.mcuadros.ApiRest_CRUD.dto.PersonRequest;
import com.mcuadros.ApiRest_CRUD.dto.PersonResponse;
import com.mcuadros.ApiRest_CRUD.service.IPersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {

    private final IPersonService personService;

    @GetMapping("/employees")
    public Flux<PersonResponse> getAll() {
        return personService.findAll();
    }

    @GetMapping("/employees/active")
    public Flux<PersonResponse> getActive() {
        return personService.findActive();
    }

    @GetMapping("/employees/inactive")
    public Flux<PersonResponse> getInactive() {
        return personService.findInactive();
    }

    @GetMapping("/employee/{id}")
    public Mono<PersonResponse> getForId(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping("/employee/")
    public Mono<PersonResponse> create(@Valid @RequestBody PersonRequest person) {
        return personService.create(person);
    }

    @PutMapping("/employee/{id}")
    public Mono<PersonResponse> update(@PathVariable Long id, @Valid @RequestBody PersonRequest person) {
        return personService.update(id, person);
    }

    @PatchMapping("/employee/{id}")
    public Mono<Void> updateStatus(@PathVariable Long id, @RequestBody String status) {
        return personService.modifyStatus(id, status);
    }

    @PatchMapping("/employee/password/{id}")
    public Mono<Void> updatePassword(@PathVariable Long id, @RequestBody String password) {
        return personService.modifyPassword(id, password);
    }

    @DeleteMapping("/employee/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return personService.delete(id);
    }

}
