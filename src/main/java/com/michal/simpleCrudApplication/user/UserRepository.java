package com.michal.simpleCrudApplication.user;


import com.michal.simpleCrudApplication.user.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {

    Optional<UserEntity> findByEmailIgnoreCase(String email);

    Page<UserEntity> findAll(Pageable pageable);
}
