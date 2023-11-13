package com.fragranceapp.fragranceapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @Email
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String name;
    private String phoneNumber;
    private String address;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long roleId;


}
