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
     * @author CuiYuming
     * @param user 用户输入的信息,包括用户名和密码
     * @return 返回注册结果
     * @throws JsonProcessingException 对象转换Json失败异常
     */
    @RequestMapping("/reg")
    String reg(User user) throws JsonProcessingException {
        // 检测空值
        if (user.getUsername() == null || user.getPassword() == null) {
            return "注册失败:用户名或密码为空";
        }
        // 将用户输入的内容保存到数据库,并获取保存后的结果
        user = userRepository.save(user);
        // 将保存后的记录转换成字符串,并输出到浏览器
        return objectMapper.writeValueAsString(user);
    }
}
