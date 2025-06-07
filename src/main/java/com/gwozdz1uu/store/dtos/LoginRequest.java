package com.gwozdz1uu.store.dtos;


import com.gwozdz1uu.store.validation.Lowercase;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Lowercase(message = "Email must be in lowercases")
    private String email;

    @NotBlank(message = "Password is required.")
    @Size(min = 6,  max = 25, message = "Password must be between 6 to 25 character long")
    private String password;
}
