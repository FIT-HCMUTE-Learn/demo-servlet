package learn.service.impl;

import learn.dao.IUserDAO;
import learn.model.UserModel;
import learn.service.IUserService;

import javax.inject.Inject;
import java.sql.SQLException;

public class UserService implements IUserService {

    @Inject
    private IUserDAO userDAO;

    @Override
    public UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status) throws SQLException {
        return userDAO.findByUsernameAndPasswordAndStatus(username, password, status);
    }
}
