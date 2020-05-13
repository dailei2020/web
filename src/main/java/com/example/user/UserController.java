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

    /**
     * 注册用户
     *
     * @param user 用户输入的信息,包括用户名和密码
     * @return 返回注册结果
     * @author CuiYuming
     */
    @RequestMapping("/reg")
    String reg(User user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            return "失败";
        }
        userRepository.save(user);
        return "成功";
    }

    /**
     * 登录
     *
     * @param user 用户输入信息
     * @return 登陆状态
     * @author CuiYuming
     */
    @RequestMapping("/login")
    String login(User user) {
        if (userRepository.existsByUsernameAndPassword(user.getUsername(), user.getPassword())) {
            return "成功";
        }
        return "失败";
    }

    /**
     * 查询用户表中所有数据
     *
     * @return 数据库中保存的信息
     * @throws JsonProcessingException Json转换异常
     * @author CuiYuming
     */
    @RequestMapping("/findAll")
    String findAll() throws JsonProcessingException {
        return objectMapper.writeValueAsString(userRepository.findAll());
    }


}
