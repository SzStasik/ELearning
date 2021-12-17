package pl.elearning.services;

import pl.elearning.model.User;

public interface UserService {
    User findByUserName(String name);

    User findByEmail(String email);

    void saveUser(User user);


//    Object findAll();
}

