package com.michal.simpleCrudApplication.user.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserOutputDTO {
    private Integer userId;
    private String email;
    private String firstName;
    private String lastName;
}
