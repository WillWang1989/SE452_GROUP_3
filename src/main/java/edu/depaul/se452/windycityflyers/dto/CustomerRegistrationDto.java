package edu.depaul.se452.windycityflyers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistrationDto {
    @Email
    @NotEmpty
    private String email;
    @Email
    @NotEmpty
    private String confirmEmail;
    @NotEmpty
    private String userName;
    private String firstName;
    private String middleName;
    private String lastName;
    @NotEmpty
    private String password;
    @NotEmpty
    private String confirmPassword;
    private LocalDateTime dob;
    private String telNo;
    private String address1;
    private String address2;
}
