package com.example.springbootlogin.dto;

import lombok.Getter;
import lombok.Setter;

// 서비스 계층과 컨트롤러 계층 간의 데이터 전송을 담당하는 객체입니다.
@Getter
@Setter
public class UserDto {
    private String id;  // 사용자 아이디
    private String password;  // 사용자 비밀번호
}
