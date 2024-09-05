package com.mcuadros.ApiRest_CRUD.mapper;

import com.mcuadros.ApiRest_CRUD.dto.PersonRequest;
import com.mcuadros.ApiRest_CRUD.dto.PersonResponse;
import com.mcuadros.ApiRest_CRUD.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonResponse toPersonResponse(Person person);
    Person toPerson(PersonRequest personRequest);

}
