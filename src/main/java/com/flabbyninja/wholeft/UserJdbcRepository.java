package com.flabbyninja.wholeft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public User findById(long id) {
        return jdbcTemplate.queryForObject("select id, first_nm as firstName, last_nm as lastName from my_users where id=?", new Object[] { id }, new BeanPropertyRowMapper<User>(User.class));
    }

    public List<User> findAll() {
        return jdbcTemplate.query("select * from my_users", new UserRowMapper());
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from my_users where id=?", new Object[] { id });
    }

    public int insert(User user) {
        return jdbcTemplate.update("insert into my_users (id, first_nm, last_nm) " + " values(?, ?, ?)",
                new Object[] { user.getId(), user.getFirstName(), user.getLastName() });
    }

    public int update(User user) {
        return jdbcTemplate.update("update my_users " + " set first_nm = ?, last_nm = ? " + " where id = ?",
                new Object[] { user.getFirstName(), user.getLastName(), user.getId()});
    }
}
