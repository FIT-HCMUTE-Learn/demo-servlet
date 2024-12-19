package learn.service;

import learn.model.NewsModel;
import learn.paging.IPageable;

import java.sql.SQLException;
import java.util.List;

public interface INewsService {
    List<NewsModel> findByCategoryId(Long id) throws SQLException;
    NewsModel save(NewsModel newsModel) throws SQLException;
    NewsModel update(NewsModel newsModel) throws SQLException;
    void delete(Long[] ids) throws SQLException;
    List<NewsModel> findAll(IPageable iPageable) throws SQLException;
    Integer getTotalItems() throws SQLException;
}
