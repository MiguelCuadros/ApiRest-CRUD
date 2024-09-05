package com.mcuadros.ApiRest_CRUD.service.impl;

import com.mcuadros.ApiRest_CRUD.dto.PersonRequest;
import com.mcuadros.ApiRest_CRUD.dto.PersonResponse;
import com.mcuadros.ApiRest_CRUD.mapper.PersonMapper;
import com.mcuadros.ApiRest_CRUD.model.Person;
import com.mcuadros.ApiRest_CRUD.repository.PersonRepository;
import com.mcuadros.ApiRest_CRUD.service.IPersonService;
import com.mcuadros.ApiRest_CRUD.util.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements IPersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public Flux<PersonResponse> findAll() {
        return personRepository.findAllByRoleOrderByCreationDate(Role.EMPLOYEE)
                .map(personMapper::toPersonResponse);
    }

    @Override
    public Flux<PersonResponse> findActive() {
        return personRepository.findAllByRoleAndStateOrderByCreationDate(Role.EMPLOYEE, "A")
                .map(personMapper::toPersonResponse);
    }

    @Override
    public Flux<PersonResponse> findInactive() {
        return personRepository.findAllByRoleAndStateOrderByCreationDate(Role.EMPLOYEE, "I")
                .map(personMapper::toPersonResponse);
    }

    @Override
    public Mono<PersonResponse> findById(Long id) {
        return personRepository.findById(id)
                .map(personMapper::toPersonResponse);
    }

    @Override
    public Mono<PersonResponse> create(PersonRequest personRequest) {
        Person person = personMapper.toPerson(personRequest);
        person.setRole(Role.EMPLOYEE);
        person.setPassword(personRequest.getDocumentNumber());
        return personRepository.save(person)
                .flatMap(personResponse -> {
                    log.info("Employee created: {}", personResponse);
                    return Mono.just(personResponse);
                })
                .map(personMapper::toPersonResponse)
                .onErrorResume(error -> {
                    log.error("Error creating employee: {}", error.getMessage());
                    return Mono.error(error);
                });
    }

    @Override
    public Mono<PersonResponse> update(Long id, PersonRequest personRequest) {
        return personRepository.findById(id)
                .flatMap(person -> {
                    person.setFirstName(personRequest.getFirstName().isEmpty() ? person.getFirstName() : personRequest.getFirstName());
                    person.setLastName(personRequest.getLastName().isEmpty() ? person.getLastName() : personRequest.getLastName());
                    person.setDocumentType(personRequest.getDocumentType().isEmpty() ? person.getDocumentType() : personRequest.getDocumentType());
                    person.setDocumentNumber(personRequest.getDocumentNumber().isEmpty() ? person.getDocumentNumber() : personRequest.getDocumentNumber());
                    person.setGender(personRequest.getGender().isEmpty() ? person.getGender() : personRequest.getGender());
                    person.setEmail(personRequest.getEmail().isEmpty() ? person.getEmail() : personRequest.getEmail());
                    person.setBirthdate(personRequest.getBirthdate() == null ? person.getBirthdate() : personRequest.getBirthdate());
                    person.setPhone(personRequest.getPhone().isEmpty() ? person.getPhone() : personRequest.getPhone());
                    person.setAddress(personRequest.getAddress().isEmpty() ? person.getAddress() : personRequest.getAddress());
                    person.setCity(personRequest.getCity().isEmpty() ? person.getCity() : personRequest.getCity());
                    person.setCountry(personRequest.getCountry().isEmpty() ? person.getCountry() : personRequest.getCountry());
                    person.setWriteDate(LocalDateTime.now());
                    return personRepository.save(person);
                })
                .map(personMapper::toPersonResponse);
    }

    @Override
    public Mono<Void> modifyPassword(Long id, String password) {
        return personRepository.findById(id)
                .flatMap(person -> {
                    person.setPassword(password);
                    return personRepository.save(person);
                })
                .then();
    }

    @Override
    public Mono<Void> modifyStatus(Long id, String status) {
        return personRepository.findById(id)
                .flatMap(person -> {
                    person.setState(status);
                    return personRepository.save(person);
                })
                .then();
    }

    @Override
    public Mono<Void> delete(Long id) {
        return personRepository.deleteById(id);
    }

}
