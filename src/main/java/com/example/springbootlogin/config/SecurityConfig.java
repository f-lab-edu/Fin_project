package com.example.springbootlogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

// 웹 보안 설정을 담당하는 클래스입니다.
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 보안 필터 체인을 설정하는 메소드입니다.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()  // 요청에 대한 보안을 설정합니다.
                .antMatchers("/login", "/signup").permitAll()  // "/login", "signup" 경로에 대한 모든 요청을 허용합니다.
                .anyRequest().authenticated()  // 그 외의 모든 요청은 인증이 필요합니다.
                .and()
                .formLogin()  // 로그인 폼을 설정합니다.
                .loginPage("/login")  // 로그인 페이지를 "/login"으로 설정합니다.
                .defaultSuccessUrl("/home")  // 로그인 성공 시 "/home"으로 리다이렉트합니다.
                .and()
                .logout()  // 로그아웃을 설정합니다.
                .logoutUrl("/logout")  // 로그아웃 경로를 "/logout"으로 설정합니다.
                .logoutSuccessUrl("/login")  // 로그아웃 성공 시 "/login"으로 리다이렉트합니다.
                .and()
                .csrf().disable();  // CSRF 보안을 비활성화합니다.
        return http.build();  // 보안 필터 체인을 반환합니다.
    }
}
