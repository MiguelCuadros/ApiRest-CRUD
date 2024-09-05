package com.mcuadros.ApiRest_CRUD.service;

import com.mcuadros.ApiRest_CRUD.dto.PersonRequest;
import com.mcuadros.ApiRest_CRUD.dto.PersonResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonService {

    Flux<PersonResponse> findAll();
    Flux<PersonResponse> findActive();
    Flux<PersonResponse> findInactive();
    Mono<PersonResponse> findById(Long id);
    Mono<PersonResponse> create(PersonRequest personRequest);
    Mono<PersonResponse> update(Long id, PersonRequest personRequest);
    Mono<Void> modifyPassword(Long id, String password);
    Mono<Void> modifyStatus(Long id, String status);
    Mono<Void> delete(Long id);

}
