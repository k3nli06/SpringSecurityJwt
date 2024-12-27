package com.k3nli.pruebaspringsecurityjwt.persistence.entities;

import java.util.Arrays;
import java.util.List;

public enum RoleEnum {
    ADMIN(Arrays.asList("ROLE_ADMIN","CREATE", "READ", "MODIFI", "DELETE")),
    DEVELOPER(Arrays.asList("ROLE_DEVELOPER", "CREATE", "READ", "MODIFI", "DELETE", "REFACTOR")),
    USER(Arrays.asList("ROLE_USER", "CREATE", "READ")),
    INVITED(Arrays.asList("ROLE_INVITED", "READ"));

    private final List<String> permissions;

    RoleEnum (List<String> permissions) {
        this.permissions = permissions;
    }

    public List<String> getPermissions () {
        return permissions;
    }
}
