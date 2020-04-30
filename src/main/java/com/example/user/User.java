package com.example.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
public class User {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Integer id;
    @Column
    String username;
    @Column
    String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        if(username==null){
String cuoWu=("您输入的用户名为空，请重新输入！");
        return cuoWu;}
        return username;
    }

    public String getPassword() {
        if(password==null){
            String cuoWu2=("您输入的密码为空，请重新输入！");
            return cuoWu2;
        }

        return password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

