package learn.service.impl;

import learn.dao.INewsDAO;
import learn.model.NewsModel;
import learn.paging.IPageable;
import learn.service.INewsService;

import javax.inject.Inject;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class NewsService implements INewsService {

    @Inject
    private INewsDAO newsDAO;

    @Override
    public List<NewsModel> findByCategoryId(Long id) throws SQLException {
        return newsDAO.findByCategoryId(id);
    }

    @Override
    public NewsModel save(NewsModel newsModel) throws SQLException {
        newsModel.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        newsModel.setCreatedBy("");
        Long newsId = newsDAO.save(newsModel);
        return newsDAO.findOne(newsId);
    }

    @Override
    public NewsModel update(NewsModel newsModel) throws SQLException {
        NewsModel oldModel = newsDAO.findOne(newsModel.getId());
        newsModel.setCreatedAt(oldModel.getCreatedAt());
        newsModel.setCreatedBy(oldModel.getCreatedBy());
        newsModel.setModifiedAt(new Timestamp(System.currentTimeMillis()));
        newsModel.setModifiedBy("");
        newsDAO.update(newsModel);
        return newsDAO.findOne(newsModel.getId());
    }

    @Override
    public void delete(Long[] ids) throws SQLException {
        for (Long id : ids) {
            // 1. delete comment
            // 2. delete news
            newsDAO.delete(id);
        }
    }

    @Override
    public List<NewsModel> findAll(IPageable iPageable) throws SQLException {
        return newsDAO.findAll(iPageable);
    }

    @Override
    public Integer getTotalItems() throws SQLException {
        return newsDAO.getTotalItems();
    }
}
