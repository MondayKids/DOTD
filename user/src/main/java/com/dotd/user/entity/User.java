package com.dotd.user.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {



    @Id
    private String id;


    @Column(name = "login_id")
    private String loginId;

    private String password;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    private String nickname;

    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;

    private Integer reward;

    @Column(name = "used_money")
    private Integer usedMoney;

    private String tier;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at")
    private LocalDateTime createdAt;


    // @PrePersist 는 엔티티가 DB에 처음 저장되기 전에 호출되는 콜백 메소드
    // 엔티티가 DB에 저장되기 전 필요한 작업을 수행할 수 있다.
    // id에 UUID 부여
    // 회원 가입 시간 부여
    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID().toString();
        this.reward = 0;
        this.usedMoney = 0;
        this.tier = "Bronze";
        this.createdAt = LocalDateTime.now();
    }


}