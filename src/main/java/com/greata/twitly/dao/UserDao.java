package com.greata.twitly.dao;

import com.greata.twitly.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;


    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public RowMapper<User> userRowMapper = (rs, _) -> new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password")
    );

    public ResponseEntity<List<User>> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = jdbcTemplate.query(sql, userRowMapper);
         return  ResponseEntity.ok(users);
    }

    public ResponseEntity<User> getUserById(long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        User user = jdbcTemplate.queryForObject(sql, userRowMapper, id);
        return  ResponseEntity.ok(user);
    }

    public ResponseEntity<User> getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        User user = jdbcTemplate.queryForObject(sql, userRowMapper, email);
        return  ResponseEntity.ok(user);
    }

    public ResponseEntity<String> SaveUser (User user) {
        if(isUserExistByEmail(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
       int rowAffected = jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword());
        return  rowAffected>0 ? ResponseEntity.ok("Success") : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    public ResponseEntity<User> updateUser(User user, long id) {
        String sql = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword(), id);
        return  ResponseEntity.ok(user);
    }

    public ResponseEntity<User> deleteUser(long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        int rowAffected = jdbcTemplate.update(sql, id);
        return  rowAffected>0? ResponseEntity.ok(new User()) : ResponseEntity.notFound().build();
    }

    private boolean isUserExistByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        List<User> users = jdbcTemplate.query(sql, userRowMapper, email);
        return !users.isEmpty();
    }
}