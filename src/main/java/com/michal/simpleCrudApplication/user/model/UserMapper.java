package com.michal.simpleCrudApplication.user.model;

public class UserMapper {

    public static UserEntity toEntity(final UserInputDTO inputDTO) {
        return UserEntity.builder()
                .email(inputDTO.getEmail())
                .firstName(inputDTO.getFirstName())
                .lastName(inputDTO.getLastName())
                .build();
    }

    public static UserOutputDTO toDTO(final UserEntity entity) {
        return UserOutputDTO.builder()
                .userId(entity.getId())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();
    }
}
