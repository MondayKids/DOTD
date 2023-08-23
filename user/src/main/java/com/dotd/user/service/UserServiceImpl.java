package com.dotd.user.service;

import com.dotd.user.dto.UserResponseDto;
import com.dotd.user.dto.UserRegisterRequestDto;
import com.dotd.user.entity.User;
import com.dotd.user.exception.FieldDataException;
import com.dotd.user.mapper.UserMapper;
import com.dotd.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Random;


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

        // 예외 발생시 클래스를 만들어 예외 처리 실행
        if (dto.getLoginId() == null || dto.getLoginId().isEmpty()) {
            throw new FieldDataException("loginId", "loginId가 비어있습니다.");
        }
        else if(dto.getPassword() == null || dto.getPassword().isEmpty()) {
            throw new FieldDataException("password", "password가 비어있습니다.");
        }

        log.info("userService의 register 실행");
        User user = userMapper.userRegisterRequestDtoToUser(dto);
        User save = userRepository.save(user);
        UserResponseDto result = userMapper.userToUserResponseDto(save);

        return result;
    }

    // 더미 회원들 등록
    @Override
    public void registDummy() {
        Random random = new Random();
        for(int i = 1; i < 10001; i++) {
            User dummyUser = User.builder()
                    .loginId("dummyid" + i)
                    .password("password" + i)
                    .lastName("kim" + i)
                    .firstName("dong" + i)
                    .nickname("nick" + i)
                    .address("address" + i)
                    .phoneNumber("phone" + i)
                    .email("email" + i)
                    .build();

            dummyUser.setUsedMoney(random.nextInt(10000) + 1);
            userRepository.save(dummyUser);
        }
    }


    // 회원 조회
    @Override
    public UserResponseDto find(String id) {
        User user = userRepository.findById(id).get();
        UserResponseDto result = userMapper.userToUserResponseDto(user);
        return result;
    }


}


