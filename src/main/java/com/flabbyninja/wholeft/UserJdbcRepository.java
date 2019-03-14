package com.flabbyninja.wholeft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class UserJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public User findById(long id) {
        return jdbcTemplate.queryForObject("select id, first_nm as firstName, last_nm as lastName, parent_id as parentId, birth_dt as birthDate, death_dt as deathDate from my_users where id=?", new Object[] { id }, new BeanPropertyRowMapper<User>(User.class));
    }

    public List<User> findAll() {
        return jdbcTemplate.query("select * from my_users", new UserRowMapper());
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from my_users where id=?", new Object[] { id });
    }

    public int insert(User user) {
        return jdbcTemplate.update("insert into my_users (id, first_nm, last_nm, parent_id, birth_dt, death_dt) " + " values(?, ?, ?, ?, ?, ?)",
                new Object[] { user.getId(), user.getFirstName(), user.getLastName(), user.getParentId(), Date.valueOf(user.getBirthDate()), Date.valueOf(user.getDeathDate()) });
    }

    public int update(User user) {
        return jdbcTemplate.update("update my_users " + " set first_nm = ?, last_nm = ?, parent_id = ?, birth_dt = ?, death_dt = ? " + " where id = ?",
                new Object[] { user.getFirstName(), user.getLastName(), user.getParentId(), Date.valueOf(user.getBirthDate()), Date.valueOf(user.getDeathDate()), user.getId() });
    }
}
