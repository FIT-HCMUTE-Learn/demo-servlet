package learn.service.impl;

import learn.dao.ICategoryDAO;
import learn.model.CategoryModel;
import learn.service.ICategoryService;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryService {

    @Inject
    private ICategoryDAO categoryDAO;

    @Override
    public List<CategoryModel> findAll() throws SQLException {
        return categoryDAO.findAll();
    }
}
