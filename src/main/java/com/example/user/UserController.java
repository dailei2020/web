package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/test")
    String aaa(){
        return "123";
    }

    @RequestMapping("/login")
    String login(User user) {
        if (user.username != null && user.password != null)
            userRepository.save(user);
       if(user.password==null || user.username==null)
           return "请输入正确的用户名密码!";
        StringBuffer resultValue = new StringBuffer();
        Iterable<User> users = userRepository.findAll();
        for (User o : users) {
            if (user.username.equals(o.username))
                if (user.password.equals(o.password))
                    return "登录成功";
        }
        return resultValue.toString();
    }
}
