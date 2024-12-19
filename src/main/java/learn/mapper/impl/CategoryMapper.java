package learn.mapper.impl;

import learn.mapper.IRowMapper;
import learn.model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements IRowMapper<CategoryModel> {
    @Override
    public CategoryModel mapRow(ResultSet rs) throws SQLException {
        try {
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setId(rs.getLong("id"));
            categoryModel.setName(rs.getString("name"));
            categoryModel.setCode(rs.getString("code"));
            categoryModel.setCreatedAt(rs.getTimestamp("created_at"));
            categoryModel.setModifiedAt(rs.getTimestamp("modified_at"));
            categoryModel.setCreatedBy(rs.getString("created_by"));
            categoryModel.setModifiedBy(rs.getString("modified_by"));
            return categoryModel;
        } catch (SQLException e) {
            return null;
        }
    }
}
