package com.example.springboot270.mapper;

import com.example.springboot270.dto.UserDto;
import com.example.springboot270.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @date 2022/5/17
 */
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "id")
    //@Mapping(source = "id", ignore = true) // 忽略，不进行映射
    @Mapping(source = "name", target = "userName")
    UserDto userToUserDto(User user);


}
