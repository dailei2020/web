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
        if(user.username==null&&user.password!=null)
            return "您输入的用户名为空，请重新输入";
        if(user.password==null&&user.username!=null)
            return "您输入的密码为空，请重新输入";
        if(user.username==null&&user.password==null)
            return "您输入的用户名和密码为空，请重新输入";
        StringBuffer resultValue=new StringBuffer();
        Iterable<User> users=userRepository.findAll();
        for(User o:users){
            if(user.username.equals(o.username))
                if(user.password.equals(o.password))
                    return "登录成功";
        }
        users.forEach(o->{
            resultValue
                    .append("username:").append(o.getUsername())
                    .append("password:").append(o.getPassword()).append("<br/>");
        });
        return resultValue.toString();
    }
}
