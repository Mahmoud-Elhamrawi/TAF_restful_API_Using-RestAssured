package com.restfulBooker.Models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserPOJO {

    @JsonProperty("username")
    private String userName;
    private String password;
    private String token;


    public UserPOJO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserPOJO(){}


    @JsonProperty("username")
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }










}
