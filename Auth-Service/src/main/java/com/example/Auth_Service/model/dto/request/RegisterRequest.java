package com.example.Auth_Service.model.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}
