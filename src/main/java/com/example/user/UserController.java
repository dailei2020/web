package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/reg")
    String reg(User user){
        if(user.username!=null&&user.password!=null)
        userRepository.save(user);
        StringBuffer resultValue=new StringBuffer();
        Iterable<User> users=userRepository.findAll();
        users.forEach(o->{
            resultValue
                    .append("username:").append(o.getUsername())
                    .append("password:").append(o.getPassword()).append("<br/>");
        });
        return resultValue.toString();
    }
}
