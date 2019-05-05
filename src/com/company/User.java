package com.company;

public class User {
    private String name;
    private String password;
    private Integer id;
    private String token;

    public User(String name, String password, Integer id, String token) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
