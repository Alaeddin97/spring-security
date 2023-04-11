package com.wrokshop.alaeddin.utils;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}
