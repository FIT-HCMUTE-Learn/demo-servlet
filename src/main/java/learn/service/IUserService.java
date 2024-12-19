package learn.service;

import learn.model.UserModel;

import java.sql.SQLException;

public interface IUserService {
    UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status) throws SQLException;
}
