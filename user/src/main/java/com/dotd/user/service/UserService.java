package com.dotd.user.service;


import com.dotd.user.dto.UserResponseDto;
import com.dotd.user.dto.UserRegisterRequestDto;

public interface UserService {

    // 회원 가입
    public UserResponseDto register(UserRegisterRequestDto dto);

    // 더미 회원들 등록
    public void registDummy();

    // 회원 조회
    public UserResponseDto find(String id);






}
