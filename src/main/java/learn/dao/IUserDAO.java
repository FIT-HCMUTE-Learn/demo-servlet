package learn.dao;

import learn.model.UserModel;

import java.sql.SQLException;

public interface IUserDAO extends IGenericDAO<UserModel>{
    UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status) throws SQLException;
}
