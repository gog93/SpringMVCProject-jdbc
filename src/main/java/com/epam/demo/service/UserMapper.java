package com.epam.demo.service;

import com.epam.demo.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt(1));
        user.setName(resultSet.getString(2));
        user.setSureName(resultSet.getString(3));
        user.setAge(resultSet.getInt(4));
        user.setEmail(resultSet.getString(5));
        user.setPassword(resultSet.getString(6));

        return user;
    }
}
