package com.emzaz.eshoppers.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDTO {
    @NotEmpty
    @Size(min = 4, max = 32)
    private String username;

    @NotEmpty
    @Size(min = 2, max = 32)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 32)
    private String lastName;

    @NotEmpty
    @Size(min = 4, max = 32)
    @Email
    private String email;

    @NotEmpty
    @Size(min = 6, max = 32)
    private String password;

    @NotEmpty
    @Size(min = 6, max = 32)
    private String passwordConfirmed;

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    }

    public String getPasswordConfirmed() {
        return passwordConfirmed;
    }

    public void setPasswordConfirmed(String passwordConfirmed) {
        this.passwordConfirmed = passwordConfirmed;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userName='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirmed='" + passwordConfirmed + '\'' +
                '}';
    }
}
