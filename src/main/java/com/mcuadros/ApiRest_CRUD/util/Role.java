package com.mcuadros.ApiRest_CRUD.util;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public enum Role {
    ADMIN(Arrays.asList(Permission.CREATE, Permission.READ, Permission.UPDATE, Permission.DELETE)),
    EMPLOYEE(Arrays.asList(Permission.CREATE, Permission.READ)),
    CUSTOMER(Arrays.asList(Permission.READ));

    private List<Permission> permissions;

}
