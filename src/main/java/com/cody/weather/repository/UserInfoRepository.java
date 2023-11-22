package com.cody.weather.repository;

import com.cody.weather.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    // 회원 정보 생성 및 수정
    UserInfo save(UserInfo userInfo);

    // 회원 정보 조회
    Optional<UserInfo> findById(String userId);

    // 비밀번호 확인을 위한 메서드 추가
    Optional<UserInfo> findByIdAndUserPw(String userId, String userPw);

    // 회원 정보 삭제
    void deleteById(String userId);
}
