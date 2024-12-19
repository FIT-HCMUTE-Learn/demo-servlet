package learn.dao;

import learn.model.NewsModel;
import learn.paging.IPageable;

import java.sql.SQLException;
import java.util.List;

public interface INewsDAO extends IGenericDAO<NewsModel> {
    NewsModel findOne(Long id) throws SQLException;
    List<NewsModel> findAll(IPageable iPageable) throws SQLException;
    List<NewsModel> findByCategoryId(Long categoryId) throws SQLException;
    Long save(NewsModel newsModel) throws SQLException;
    void update(NewsModel newsModel) throws SQLException;
    void delete(Long id) throws SQLException;
    Integer getTotalItems() throws SQLException;
}
