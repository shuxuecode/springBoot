package com.example.springboot270.mapper;

import com.example.springboot270.dto.UserDto;
import com.example.springboot270.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @date 2022/5/17
 */
@Mapper
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "userName")
    UserDto userToUserDto(User user);

}
