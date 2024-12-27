package com.k3nli.pruebaspringsecurityjwt.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDto {
    private String Username;

    private String password;
}
