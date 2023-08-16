package com.dotd.user.controller;


import com.dotd.user.dto.UserRegisterRequestDto;
import com.dotd.user.dto.UserResponseDto;
import com.dotd.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;

    
    // 회원 등록 
    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterRequestDto dto) {
        UserResponseDto result = userService.register(dto);
        return ResponseEntity.ok(result);
    }

    // 회원 한 명 조회
    @GetMapping("find")
    public ResponseEntity<?> findUser(@RequestHeader("id") String id) {
        UserResponseDto result = userService.find(id);
        return ResponseEntity.ok(result);
    }











}
