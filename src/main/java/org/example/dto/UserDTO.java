package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

    @JsonProperty("username")
    private String username;
    @JsonProperty("common_name")
    private String commonName;
    @JsonProperty("surname")
    private String surname;

    public UserDTO() {}

    public UserDTO(String username, String commonName, String surname) {
        this.username = username;
        this.commonName = commonName;
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
