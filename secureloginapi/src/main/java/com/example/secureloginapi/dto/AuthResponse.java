package com.example.secureloginapi.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor public class AuthResponse {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}