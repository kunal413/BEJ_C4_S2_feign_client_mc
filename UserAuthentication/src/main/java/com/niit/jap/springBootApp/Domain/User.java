package com.niit.jap.springBootApp.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String userPassword;
    private String emailId;

    public User(String userPassword, String emailId) {
        this.userPassword = userPassword;
        this.emailId = emailId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userPassword='" + userPassword + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }

    public User() {
    }
}
