package com.cody.weather.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfo {
    @Id
    private String userId;
    private String userPw;
    private String userName;
    private String userGender;
    private String userLocate;

    // Constructors
    public UserInfo() {
    }

    public UserInfo(String userId, String userPw, String userName, String userGender, String userLocate) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userGender = userGender;
        this.userLocate = userLocate;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserLocate() {
        return userLocate;
    }

    public void setUserLocate(String userLocate) {
        this.userLocate = userLocate;
    }
}
