package com.michal.simpleCrudApplication.user.validator;

import com.michal.simpleCrudApplication.Validator;
import com.michal.simpleCrudApplication.exception.InvalidOperationException;
import com.michal.simpleCrudApplication.user.UserRepository;
import com.michal.simpleCrudApplication.user.model.UserEntity;
import com.michal.simpleCrudApplication.user.model.UserInputDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public final class UserExistsValidator implements Validator<UserInputDTO> {

    private final UserRepository userRepository;

    @Override
    public void validate(final UserInputDTO dto) {
        Optional<UserEntity> byEmail = userRepository.findByEmailIgnoreCase(dto.getEmail());
        if (byEmail.isPresent()) {
            throw new InvalidOperationException("User already exists");
        }
    }
}
