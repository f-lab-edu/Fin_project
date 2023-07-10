package com.example.springbootlogin.controller;

import com.example.springbootlogin.dao.UserDao;
import com.example.springbootlogin.dto.UserDto;
import com.example.springbootlogin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// 클라이언트의 요청을 처리하는 컨트롤러 클래스입니다.
@Controller
public class LoginController {
    /*
    필드 주입 방식
    @Autowired  // 스프링 컨테이너로부터 필드 주입 방식으로 UserDao 객체를 주입
    private UserDao userDao;
    */

    //생성자 주입방식
    private final UserDao userDao;

    @Autowired
    public LoginController(UserDao userDao) {
        this.userDao = userDao;
    }

    // "/login" 경로의 GET 요청을 처리하는 메소드입니다.
    @GetMapping("/login")
    public String loginPage(Model model) {
        System.out.println("로그인 핸들러");  // 콘솔에 로그 출력
        return "login";  // "login" 뷰를 반환합니다.
    }

    // "/signup" 경로의 GET 요청을 처리하는 메소드입니다.
    @GetMapping("/signup")
    public String signupPage(Model model) {
        return "signup";  // "signup" 뷰를 반환합니다.
    }

    // "/signup" 경로의 POST 요청을 처리하는 메소드입니다. 사용자 등록을 담당합니다.
    @PostMapping("/signup")
    public String handleSignupPage(UserDto userDto) {
        User user = new User();  // User 객체 생성
        user.setId(userDto.getId());  // id 설정

        // 비밀번호 enco
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(userDto.getPassword());

        user.setPassword(hashedPassword);   // password 설정

        userDao.addUser(user);  // UserDao로 사용자 등록
        return "redirect:/login";  // "/login"으로 리다이렉트
    }

    // "/home" 경로의 GET 요청을 처리하는 메소드입니다.
    @GetMapping("/home")
    public String homePage() {
        return "home";  // "home" 뷰를 반환합니다.
    }

}
