package com.michal.simpleCrudApplication.user;

import com.michal.simpleCrudApplication.user.model.UserEntity;
import com.michal.simpleCrudApplication.user.model.UserInputDTO;
import com.michal.simpleCrudApplication.user.model.UserMapper;
import com.michal.simpleCrudApplication.user.model.UserOutputDTO;
import com.michal.simpleCrudApplication.user.validator.UserInputValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserInputValidator validator;

    public UserOutputDTO createUser(final UserInputDTO newUser) {
        validator.validateInputUser(newUser);
        UserEntity created = userRepository.save(UserMapper.toEntity(newUser));
        return UserMapper.toDTO(created);
    }

    public Page<UserOutputDTO> getAllUsers(final Pageable pageable) {
        Page<UserEntity> all = userRepository.findAll(pageable);
        return all.map(UserMapper::toDTO);
    }

    public Optional<UserOutputDTO> getOneByEmail(final String email) {
        Optional<UserEntity> byEmailIgnoreCase = userRepository.findByEmailIgnoreCase(email);
        return byEmailIgnoreCase.map(UserMapper::toDTO);
    }

}
