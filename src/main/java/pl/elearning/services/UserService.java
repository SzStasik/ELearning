package pl.elearning.services;

import pl.elearning.model.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
}
