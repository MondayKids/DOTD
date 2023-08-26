package com.dotd.user.controller;


import com.dotd.user.dto.user.UserRegisterRequestDto;
import com.dotd.user.dto.user.UserResponseDto;
import com.dotd.user.service.user.UserService;
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


    // 더미 회원들 등록
    @PostMapping("regist-dummy")
    public ResponseEntity<?> registDummy( ) {
        userService.registDummy();
        return ResponseEntity.ok("ok");
    }

    // 회원 한 명 조회
    @GetMapping("find")
    public ResponseEntity<?> findUser(@RequestHeader("id") String id) {
        UserResponseDto result = userService.find(id);
        return ResponseEntity.ok(result);
    }











}
