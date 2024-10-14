package com.thinkon.exercise.UserService.repository;

import com.thinkon.exercise.UserService.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
