package learn.dao;

import learn.model.CategoryModel;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDAO extends IGenericDAO<CategoryModel>{
    List<CategoryModel> findAll() throws SQLException;
}
