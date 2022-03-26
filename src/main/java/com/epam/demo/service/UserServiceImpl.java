package com.epam.demo.service;

import com.epam.demo.db.DBConnectionProvider;
import com.epam.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

public class UserServiceImpl implements Service<User, Integer>{
    private Connection connection = DBConnectionProvider.getInstance().getConnection();


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    DataSource dataSource;
    private  User user=new User();

    @Override
        public void create(User user) {
            String query = "INSERT INTO `user` (`name`,`surename`,`age`,`email`,`password`) " +
                    "VALUES(?,?,?,?,?);";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getSureName());
                preparedStatement.setInt(3, user.getAge());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getPassword());

                preparedStatement.executeUpdate();
                ResultSet generateedKey = preparedStatement.getGeneratedKeys();
                if (generateedKey.next()) {
                    long id = generateedKey.getLong(1);
                    user.setId(id);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }


    @Override
    public User getByEmailAndPassword(String email, String password ) {
        String sql = "SELECT * FROM user WHERE email='" + email + "' and password = '" + password+"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setSureName(resultSet.getString(3));
                user.setAge(resultSet.getInt(4));
                user.setEmail(resultSet.getString(5));
                user.setPassword(resultSet.getString(6));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;    }
}
