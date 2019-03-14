package com.flabbyninja.wholeft;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setFirstName(rs.getString("first_nm"));
        user.setLastName(rs.getString("last_nm"));
        user.setParentId(rs.getLong("parent_id"));
        user.setBirthDate(rs.getDate("birth_dt").toLocalDate());
        user.setDeathDate(rs.getDate("death_dt").toLocalDate());
        return user;
    }
}
