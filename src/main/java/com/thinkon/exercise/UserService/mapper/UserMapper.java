package com.thinkon.exercise.UserService.mapper;

import com.thinkon.exercise.UserService.entity.UserEntity;
import com.thinkon.exercise.UserService.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User map(UserEntity entity);

    UserEntity map(User model);

}
