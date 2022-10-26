package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {
    @NotBlank(message = "Enter a username.")
    @Size(min = 5, max = 15, message = "Username must be 5-15 characters.")
    private String username;

    @Email(message = "Enter a valid email address.")
    private String email;

    @NotBlank(message = "Enter a password.")
    @Size(min = 6, message = "Password must be at least 6 characters long.")
    private String password;

    @NotNull(message = "Passwords must match.")
    private String verifyPassword;

    private void checkPassword(String password, String verifyPassword) {
        if (password != null && verifyPassword != null && !password.equals(verifyPassword)) {
            this.verifyPassword = null;
        }
    }
    public User() {

    }

    public User(String username, String email, String password, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
        checkPassword(password,verifyPassword);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword(password,verifyPassword);
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword(password,verifyPassword);
    }
}
