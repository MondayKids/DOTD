package com.dotd.user.mapper;


import com.dotd.user.dto.UserRegisterRequestDto;
import com.dotd.user.dto.UserResponseDto;
import com.dotd.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // UserMapper instance = Mappers.getMapper(UserMapper.class);

    // 유저 정보를 반환
    UserResponseDto userToUserResponseDto(User user);


    // 회원 가입 폼을 유저로 반환
    User userRegisterRequestDtoToUser(UserRegisterRequestDto dto);


}
