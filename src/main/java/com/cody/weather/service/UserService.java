package com.cody.weather.service;

import com.cody.weather.model.UserInfo;
import com.cody.weather.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;
    
    // 로그인 상태 확인
    public boolean isLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated() && !("anonymousUser").equals(authentication.getPrincipal());
    }
    
    // 회원 정보 생성 및 수정
    public UserInfo saveUser(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    // 회원 정보 조회
    public Optional<UserInfo> findByIdAndPassword(String userId, String password) {
        Optional<UserInfo> userInfoOptional = userInfoRepository.findByIdAndUserPw(userId, password);

        if (userInfoOptional.isPresent()) {
            return userInfoOptional; // 비밀번호 일치
        } else {
            // 비밀번호 불일치 또는 사용자가 존재하지 않음
            return Optional.empty();
        }
    }

    // 회원 정보 삭제
    public boolean deleteUser(String userId, String password) {
        Optional<UserInfo> userInfoOptional = userInfoRepository.findByIdAndUserPw(userId, password);

        if (userInfoOptional.isPresent()) {
            userInfoRepository.deleteById(userId);
            return true; // 삭제 성공
        } else {
            // 비밀번호 불일치 또는 사용자가 존재하지 않음
            return false; 
        }
    }
}
