package pl.elearning.servicesImpl;

import org.springframework.stereotype.Service;
import pl.elearning.model.Role;
import pl.elearning.repositories.RoleRepository;
import pl.elearning.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}