package com.michal.simpleCrudApplication.user.validator;

import com.michal.simpleCrudApplication.Constants;
import com.michal.simpleCrudApplication.Validator;
import com.michal.simpleCrudApplication.exception.InvalidOperationException;
import com.michal.simpleCrudApplication.user.model.UserInputDTO;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public final class EmailAddressValidator implements Validator<UserInputDTO> {

    @Override
    public void validate(final UserInputDTO dto) {
        String email = dto.getEmail();
        Pattern pattern = Pattern.compile(Constants.EMAIL_VALIDATION_REGEXP);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new InvalidOperationException("Invalid email address");
        }
    }
}
