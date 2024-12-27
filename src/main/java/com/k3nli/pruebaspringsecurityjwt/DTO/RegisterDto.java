package com.k3nli.pruebaspringsecurityjwt.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterDto {
    private String email;

    private String username;

    private String password;
}