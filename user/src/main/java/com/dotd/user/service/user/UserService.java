package com.dotd.user.service.user;


import com.dotd.user.dto.user.UserResponseDto;
import com.dotd.user.dto.user.UserRegisterRequestDto;

public interface UserService {

    // 회원 가입
    public UserResponseDto register(UserRegisterRequestDto dto);

    // 더미 회원들 등록
    public void registDummy();

    // 회원 조회
    public UserResponseDto find(String id);






}
