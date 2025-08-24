package com.whoisdm.characterFolder.model.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegistrationUser {
    @NotNull(message = "Username is required")
    @Size(min = 3, message = "More or equal to 3 symbols!")
    private String username;

    @NotNull(message = "Password is required")
    @Size(min = 6, message = "More or equal to 6 symbols!")
    private String password;

    private String passwordConfirm;

    public RegistrationUser() {
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
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
