package com.jerry.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * User: Jerry
 * Date: 2020/10/17
 * Time: 14:28
 * Description:
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User create(@RequestBody User user) {
        return user;
    }

    @PutMapping("/{id}")
    public User update(@RequestBody User user) {
        return user;
    }

    @DeleteMapping("/{id}")
    public void update(@PathVariable Long id) {
    }

    @GetMapping("{id}")
    public User get(@PathVariable Long id) {
        return new User();
    }

    @GetMapping("/queryJdbc")
    public List<Map<String, Object>> queryJdbc(String name) {
        String sql = "SELECT id, name FROM user WHERE name = '" + name + "'";
        List<Map<String, Object>> data = jdbcTemplate.queryForList(sql);
        return data;
    }

    @GetMapping("/query")
    public List<User> query(String name) {
        return userRepository.findByName(name);
    }

}
