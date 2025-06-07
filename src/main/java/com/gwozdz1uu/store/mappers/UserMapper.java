package com.gwozdz1uu.store.mappers;

import com.gwozdz1uu.store.dtos.RegisterUserRequest;
import com.gwozdz1uu.store.dtos.UpdateUserRequest;
import com.gwozdz1uu.store.dtos.UserDto;
import com.gwozdz1uu.store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

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
    void updateEntity(UpdateUserRequest request,@MappingTarget User user);



    User toEntity(RegisterUserRequest request); //to sie czesto psuje
//    default User toEntity(RegisterUserRequest request) {if (request == null) return null;
//        return new User();
//    }
}



