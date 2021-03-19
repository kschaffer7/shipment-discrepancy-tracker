package org.launchcode.shipmentdiscrepancytracker.models.dto;


import org.jetbrains.annotations.NotNull;

public class LoginFormDTO {


    private String username;

    private String password;

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
