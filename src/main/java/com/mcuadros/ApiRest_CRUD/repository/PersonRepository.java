package com.mcuadros.ApiRest_CRUD.repository;

import com.mcuadros.ApiRest_CRUD.model.Person;
import com.mcuadros.ApiRest_CRUD.util.Role;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PersonRepository extends R2dbcRepository<Person, Long> {

    Flux<Person> findAllByRoleOrderByCreationDate(Role role);
    Flux<Person> findAllByRoleAndStateOrderByCreationDate(Role role, String state);
    Mono<Person> findByEmail(String email);

}
