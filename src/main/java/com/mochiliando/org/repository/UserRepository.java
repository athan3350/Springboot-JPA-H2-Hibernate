package com.mochiliando.org.repository;

import com.mochiliando.org.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByOwnerEmailAndPassword (String email, String password);
    Optional<UserEntity> findByOwnerEmail (String email);
}