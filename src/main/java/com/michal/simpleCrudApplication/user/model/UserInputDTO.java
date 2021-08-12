package com.michal.simpleCrudApplication.user.model;

import lombok.Data;

@Data
public class UserInputDTO {
    private String email;
    private String firstName;
    private String lastName;
}
