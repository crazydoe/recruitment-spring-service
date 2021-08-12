package com.michal.simpleCrudApplication.user.validator;

import com.michal.simpleCrudApplication.Validator;
import com.michal.simpleCrudApplication.user.model.UserInputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public final class UserInputValidator {

    private final Set<Validator<UserInputDTO>> validators;

    public void validateInputUser(final UserInputDTO newUser) {

        validators.forEach(validator -> validator.validate(newUser));
    }
}
