package com.bezkoder.springbootjpah2.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;


}
