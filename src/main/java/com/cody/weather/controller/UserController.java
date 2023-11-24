package com.cody.weather.controller;

import com.cody.weather.model.UserInfo;
import com.cody.weather.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup";
    }

    @GetMapping("/user/profile")
    public String showUserProfile(@RequestParam String userId, Model model) {
        Optional<UserInfo> userInfoOptional = userService.findById(userId);

        if (userInfoOptional.isPresent()) {
            UserInfo userInfo = userInfoOptional.get();
            model.addAttribute("userInfo", userInfo);
            return "userProfile"; // 사용자 정보를 화면에 표시하는 페이지로 이동
        } else {
            // 사용자 정보가 없을 경우에 대한 처리 (예: 에러 메시지 표시 등)
            return "errorPage"; // 예시로 errorPage로 이동하도록 설정
        }
    }

    @PostMapping("/user/login")
    public String loginUser(@RequestParam String userId, @RequestParam String password, Model model) {
        Optional<UserInfo> userInfoOptional = userService.findByIdAndPassword(userId, password);

        if (userInfoOptional.isPresent()) {
            UserInfo userInfo = userInfoOptional.get();
            model.addAttribute("userInfo", userInfo);
            return "userProfile"; // 로그인 성공 시 프로필 페이지로 이동
        } else {
            model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
            return "login"; // 로그인 실패 시 로그인 페이지로 이동
        }
    }

    @GetMapping("/user/delete")
    public String showDeleteForm() {
        return "deleteForm";
    }

    @PostMapping("/user/delete")
    public String deleteUser(@RequestParam String userId, @RequestParam String password, Model model) {
        boolean isDeleted = userService.deleteUser(userId, password);

        if (isDeleted) {
            return "deleteSuccess"; // 삭제 성공 시 성공 페이지로 이동
        } else {
            model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
            return "deleteForm"; // 삭제 실패 시 삭제 폼 페이지로 이동
        }
    }
}