package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String save(User user) throws UsernameTooLongException, PasswordTooLongException {
        if (user.getUsername().length() >= 60) {
            throw new UsernameTooLongException();
        }
        if (user.getPassword().length() >= 60) {
            throw new PasswordTooLongException();
        }
        return "完成";
    }
}
