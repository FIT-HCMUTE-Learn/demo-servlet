package learn.dao.impl;

import learn.dao.IUserDAO;
import learn.mapper.impl.UserMapper;
import learn.model.UserModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends GenericDAO<UserModel> implements IUserDAO {

    @Override
    public UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status) throws SQLException {
        StringBuilder sql = new StringBuilder("SELECT * FROM user ");
        sql.append(" INNER JOIN role AS r ON r.id = user.roleId ");
        sql.append(" WHERE username = ? AND password = ? AND status = ?");
        List<UserModel> users = query(sql.toString(), new UserMapper(), username, password, status);
        return users.isEmpty() ? null : users.get(0);
    }
}
