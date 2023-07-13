package com.example.springbootlogin.security.config;

import com.example.springbootlogin.security.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 보안 필터 체인을 설정하는 메소드입니다.
        http
                .authorizeRequests()
                .antMatchers("/login", "/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/login", "/signup").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .failureUrl("/login")
                .and()
                .logout()
                .logoutUrl("/logout")
                .and()
                .csrf().disable();
        return http.build();
    }
}
