package com.dotd.user.service;

import com.dotd.user.dto.UserResponseDto;
import com.dotd.user.dto.UserRegisterRequestDto;
import com.dotd.user.entity.User;
import com.dotd.user.mapper.UserMapper;
import com.dotd.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/*

user의 비지니스 로직을 처리하는 클래스

 */


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {


    // repository
    private final UserRepository userRepository;


    // mapper
    private final UserMapper userMapper;


    // 회원 등록
    @Override
    public UserResponseDto register(UserRegisterRequestDto dto) {

        // log.info("{}", dto);
        // log.info("user : {}", user);
        log.info("userService의 register 실행");
        User user = userMapper.userRegisterRequestDtoToUser(dto);
        User save = userRepository.save(user);
        UserResponseDto result = userMapper.userToUserResponseDto(save);

        return result;
    }


    // 회원 조회
    @Override
    public UserResponseDto find(String id) {
        User user = userRepository.findById(id).get();
        UserResponseDto result = userMapper.userToUserResponseDto(user);
        return result;
    }
}


//        User user = User.builder()
//                .loginId(dto.getLoginId())
//                .password(dto.getPassword())
//                .lastName(dto.getLastName())
//                .firstName(dto.getFirstName())
//                .nickname(dto.getNickname())
//                .address(dto.getAddress())
//                .phoneNumber(dto.getPhoneNumber())
//                .email(dto.getEmail())
//                .build();

//        UserResponseDto result = UserResponseDto.builder()
//                .id(save.getId())
//                .loginId(save.getLoginId())
//                .password(save.getPassword())
//                .lastName(save.getLastName())
//                .firstName(save.getFirstName())
//                .nickname(save.getNickname())
//                .address(save.getAddress())
//                .phoneNumber(save.getPhoneNumber())
//                .email(save.getEmail())
//                .reward(save.getReward())
//                .usedMoney(save.getUsedMoney())
//                .tier(save.getTier())
//                .createdAt(save.getCreatedAt())
//                .build();