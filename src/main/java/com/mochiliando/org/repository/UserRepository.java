package com.mochiliando.org.repository;

import com.mochiliando.org.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {}