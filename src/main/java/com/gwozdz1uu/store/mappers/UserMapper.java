package com.gwozdz1uu.store.mappers;

import com.gwozdz1uu.store.users.RegisterUserRequest;
import com.gwozdz1uu.store.users.UpdateUserRequest;
import com.gwozdz1uu.store.users.UserDto;
import com.gwozdz1uu.store.users.User;
import org.mapstruct.Mapper;
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



//    User toEntity(RegisterUserRequest request); //to sie czesto psuje
    default User toEntity(RegisterUserRequest request) {
        if (request == null) return null;

        User.UserBuilder user = User.builder();

        user.name( request.getName() );
        user.email( request.getEmail() );
        user.password( request.getPassword() );

        return user.build();
    }
}



