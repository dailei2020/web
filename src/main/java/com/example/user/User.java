package com.example.user;

import javax.persistence.*;

@Entity
public class User {
    @Column
    String username;
    @Column
    String password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

