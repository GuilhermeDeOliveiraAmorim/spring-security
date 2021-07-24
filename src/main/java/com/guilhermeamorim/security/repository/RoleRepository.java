package com.guilhermeamorim.security.repository;

import com.guilhermeamorim.security.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}