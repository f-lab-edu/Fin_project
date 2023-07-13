package com.example.springbootlogin.entity;

import lombok.Getter;
import lombok.Setter;

// 사용자의 정보를 나타내는 클래스입니다. 이 클래스의 객체는 데이터베이스의 레코드와 직접적으로 연결됩니다.

/*
처음에는 entity에 g,setter을 다는것은 안좋은거같았는데 (데이터 무결성 :데이터가 서로 일치하는 상태의 문제)
외부에 보여지게 쓰는 public한 @getter, setter을 조심 하게 쓰야 하는것을 알았다
 */
@Getter
@Setter
public class User {
    private String id;  // 사용자 아이디
    private String password;  // 사용자 비밀번호
}
