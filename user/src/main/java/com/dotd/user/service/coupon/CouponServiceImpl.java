package com.dotd.user.service.coupon;


import com.dotd.user.dto.coupon.CouponRegisterRequestDto;
import com.dotd.user.dto.coupon.CouponResponseDto;
import com.dotd.user.entity.Coupon;
import com.dotd.user.mapper.CouponMapper;
import com.dotd.user.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;
    private final CouponMapper couponMapper;

    // 쿠폰 등록
    public CouponResponseDto register(CouponRegisterRequestDto dto) {
        Coupon coupon = couponMapper.couponRegisterRequestDtoToCoupon(dto);
        Coupon save = couponRepository.save(coupon);
        CouponResponseDto result = couponMapper.couponToCouponResponseDto(coupon);
        return result;
    }

    // 쿠폰 조회
    @Override
    public CouponResponseDto find(Integer id) {
        Coupon coupon = couponRepository.findById(id).get();
        CouponResponseDto result = couponMapper.couponToCouponResponseDto(coupon);
        return result;
    }


}
