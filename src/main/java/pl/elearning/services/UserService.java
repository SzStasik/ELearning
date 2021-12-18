package pl.elearning.services;

import pl.elearning.model.User;

public interface UserService {
    User get(Long id);

    User findByUserName(String name);

    User findByEmail(String email);

    void saveUser(User user);

    void delete(Long id);

    Object findAll();

}

