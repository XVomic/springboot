package com.xxc.learnboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "T_user")     //定义表名
public class User {
    @Id     //定义主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)         //自增主键
    private int id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
