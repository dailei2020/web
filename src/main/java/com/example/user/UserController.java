package com.example.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/reg")
    String reg(User user) {
        if (user.getUsername() != null && user.getPassword() != null) {
            userRepository.save(user);
            System.out.println("跳转到登录界面");
            return "成功";
        } else {
            System.out.println("登录到失败页面");
            return "失败";
        }
    }

    @RequestMapping("/login")
    String login(User user) {
        System.out.println("注册成功请登录");
        User user1=userRepository.findByUsername(user.getUsername());
        if(user.getPassword().equals(user1.getPassword()))
            return "成功";
        else return "失败";
    }
    @RequestMapping("/findAll")
    String findAll(User user) throws JsonProcessingException {
        return objectMapper.writeValueAsString(userRepository.findAll());
    }
}