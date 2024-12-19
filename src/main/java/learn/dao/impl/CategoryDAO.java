package learn.dao.impl;

import learn.dao.ICategoryDAO;
import learn.mapper.impl.CategoryMapper;
import learn.model.CategoryModel;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class CategoryDAO extends GenericDAO<CategoryModel> implements ICategoryDAO {

    @Override
    public List<CategoryModel> findAll() throws SQLException {
        String sql = "SELECT * FROM category";
        return query(sql, new CategoryMapper());
    }
}
