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
        return username;
    }

    public String getPassword() {
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

