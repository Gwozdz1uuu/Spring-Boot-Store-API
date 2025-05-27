package com.gwozdz1uu.store.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor()
@Data

public class UserDto {
    private Long id;
    private String name;
    private String email;


}
