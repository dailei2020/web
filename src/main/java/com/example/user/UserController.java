package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/test")
    String aaa() {
        return "123";
    }

    @RequestMapping("/zhuce")
    ModelAndView zhuce(User user) {
        if (user.username !=null&&user.password !=null&& !"".equals(user.username)&& !"".equals(user.password)) {
            userRepository.save(user);
            return new ModelAndView("/login.html");
        } else {
            return new ModelAndView("/fail.html");
        }
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
}
