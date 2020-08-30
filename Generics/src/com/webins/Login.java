package com.webins;

public class Login<T> {
    private String username;
    private T password;

    public Login(String username, T password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public T getPassword() {
        return password;
    }

    public void setPassword(T password) {
        this.password = password;
    }
}
