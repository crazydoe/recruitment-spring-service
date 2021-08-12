package com.michal.simpleCrudApplication.user;

import com.michal.simpleCrudApplication.user.model.UserInputDTO;
import com.michal.simpleCrudApplication.user.model.UserOutputDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserOutputDTO> createUser(@RequestBody UserInputDTO inputDTO) {
        UserOutputDTO user = userService.createUser(inputDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Page<UserOutputDTO>> getAllUsers(Pageable pageable) {
        Page<UserOutputDTO> allUsers = userService.getAllUsers(pageable);
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping(path = "{email}")
    public ResponseEntity<UserOutputDTO> findByEmail(@PathVariable("email") @NotNull String email) {
        Optional<UserOutputDTO> user = userService.getOneByEmail(email);
        return user.map(o -> new ResponseEntity<>(o, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
