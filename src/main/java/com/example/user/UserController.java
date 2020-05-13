package com.example.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/test")
    String aaa() {
        return "123";
    }

    @RequestMapping("/reg")
    String reg(User user) throws JsonProcessingException {
        if (user.getUsername() == null || user.getPassword() == null) {
            return "注册失败:用户名或密码为空";
        }
        return objectMapper.writeValueAsString(user);
    }

    @RequestMapping("/login")
    String login(User user) {
        System.out.println("注册成功请登录");
        Iterable<User> users = userRepository.findAll();
        for (User o : users) {
            if (user.username.equals(o.username))
                if (user.password.equals(o.password))
                    return "登录成功";
        }
        return "登陆失败";
    }

    @RequestMapping("/findall")
    String findAll() throws JsonProcessingException {

        Iterable<User> users = userRepository.findAll();
        return objectMapper.writeValueAsString(users);

    }
}
