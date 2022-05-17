package com.example.springboot270.mapper;

import com.example.springboot270.dto.UserDto;
import com.example.springboot270.dto.UserRoleDto;
import com.example.springboot270.entity.Role;
import com.example.springboot270.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Date;

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


    /**
     * 多个source参数的映射方法
     * <p>
     * 在将多个bean合并成一个bean的时候非常有用
     *
     * @param user
     * @param role
     * @return
     */
    @Mapping(source = "user.name", target = "userName")
    @Mapping(source = "role.roleName", target = "roleName")
    UserRoleDto getUserRoleDto(User user, Role role);


    @Mapping(source = "user.name", target = "userName")
    // 直接引用一个source参数映射到target对象
    @Mapping(source = "date", target = "birthday")
    UserDto userToUserDto(User user, Date date);
}
