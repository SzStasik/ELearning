package pl.elearning.services;

import pl.elearning.model.Role;

public interface RoleService {
    Role findByName(String name);
}