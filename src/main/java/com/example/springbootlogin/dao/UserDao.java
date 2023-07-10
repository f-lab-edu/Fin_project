package com.example.springbootlogin.dao;

import com.example.springbootlogin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

// 데이터베이스 연동을 담당하는 DAO 클래스입니다.
@Repository
public class UserDao {

    @Autowired  // 스프링 컨테이너로부터 JdbcTemplate 객체를 주입받습니다.
    private JdbcTemplate jdbcTemplate;

    // 사용자 정보를 데이터베이스에 추가하는 메소드입니다.
    public void addUser(User user) {

        String sql = "INSERT INTO users (id, password) VALUES (?, ?)";  // SQL 문장
        jdbcTemplate.update(sql, user.getId(), user.getPassword());  // SQL 실행
        // entity에 g,setter을
    }

    // 사용자 ID를 이용하여 데이터베이스에서 사용자 정보를 가져오는 메소드입니다.
    public User getUserById(String id) {
        String sql = "SELECT * FROM users WHERE id = ?";  // SQL 문장
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);  // SQL 실행
    }

    // ResultSet의 레코드를 User 객체에 매핑하는 메소드입니다.
    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();  // User 객체 생성
            user.setId(rs.getString("id"));  // id 설정
            user.setPassword(rs.getString("password"));  // password 설정
            return user;  // User 객체 반환
            // https://code-lab1.tistory.com/277
            // https://velog.io/@seculoper235/RowMapper%EC%97%90-%EB%8C%80%ED%95%B4
        }
    }
}
