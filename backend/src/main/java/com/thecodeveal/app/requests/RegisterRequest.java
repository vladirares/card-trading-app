package com.thecodeveal.app.requests;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}
