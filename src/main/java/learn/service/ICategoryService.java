package learn.service;

import learn.model.CategoryModel;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll() throws SQLException;
}
