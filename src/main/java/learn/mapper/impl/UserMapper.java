package learn.mapper.impl;

import learn.mapper.IRowMapper;
import learn.model.RoleModel;
import learn.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements IRowMapper {
    @Override
    public Object mapRow(ResultSet rs) throws SQLException {
        try {
            UserModel userModel = new UserModel();
            userModel.setId(rs.getLong("id"));
            userModel.setUsername(rs.getString("username"));
            userModel.setPassword(rs.getString("password"));
            userModel.setFullName(rs.getString("fullName"));
            userModel.setStatus(rs.getInt("status"));

            try {
                RoleModel roleModel = new RoleModel();
                roleModel.setName(rs.getString("name"));
                roleModel.setCode(rs.getString("code"));
                userModel.setRole(roleModel);
            } catch (Exception e) {
                e.printStackTrace();
            }

            userModel.setCreatedAt(rs.getTimestamp("createdAt"));
            if (rs.getTimestamp("modifiedAt") != null) {
                userModel.setModifiedAt(rs.getTimestamp("modifiedAt"));
            }
            userModel.setCreatedBy(rs.getString("createdBy"));
            if (rs.getString("modifiedBy") != null) {
                userModel.setModifiedBy(rs.getString("modifiedBy"));
            }
            return userModel;
        } catch (SQLException e) {
            return null;
        }
    }
}
