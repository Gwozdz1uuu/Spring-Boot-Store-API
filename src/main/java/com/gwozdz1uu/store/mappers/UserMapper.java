package com.gwozdz1uu.store.mappers;

import com.gwozdz1uu.store.dtos.RegisterUserRequest;
import com.gwozdz1uu.store.dtos.UserDto;
import com.gwozdz1uu.store.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    default UserDto toDto(User user) {
        if (user == null) return null;

        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
//    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
//    default User toEntity(RegisterUserRequest request) {
//        if (request == null) return null;
//
//        return new User(
//                request.getName(),
//                request.getEmail(),
//                request.getPassword()
//        );
//    }
}



