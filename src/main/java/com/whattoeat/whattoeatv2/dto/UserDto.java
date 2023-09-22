package com.whattoeat.whattoeatv2.dto;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{
    private Long id;
    @NotEmpty(message = "Username should not be empty")
    private String username;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Password should not be empty")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]).{8,}$",
            message = "Password should contains at least 8 characters, a number, a lowercase letter, an uppercase letter")
    private String password;
}
