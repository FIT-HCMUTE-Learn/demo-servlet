package learn.dao.impl;

import learn.dao.INewsDAO;
import learn.mapper.impl.NewsMapper;
import learn.model.NewsModel;
import learn.paging.IPageable;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class NewsDAO extends GenericDAO<NewsModel> implements INewsDAO {

    @Override
    public NewsModel findOne(Long id) throws SQLException {
        String sql = "SELECT * FROM news WHERE id = ?";
        List<NewsModel> newsModelList = query(sql, new NewsMapper(), id);
        return newsModelList.isEmpty() ? null : newsModelList.get(0);
    }

    @Override
    public List<NewsModel> findAll(IPageable iPageable) throws SQLException {
        StringBuilder sql = new StringBuilder("SELECT * FROM news");
        if (iPageable.getSorter() != null) {
            sql.append(" ORDER BY ").append(iPageable.getSorter().getSortName());
            sql.append(" ").append(iPageable.getSorter().getSortBy());
        }
        if (iPageable.getOffset() != null && iPageable.getLimit() != null) {
            sql.append(" LIMIT ?, ?");
        }
        return query(sql.toString(), new NewsMapper(), iPageable.getOffset(), iPageable.getLimit());
    }

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) throws SQLException {
        String sql = "SELECT * FROM news WHERE categoryId = ?";
        return query(sql, new NewsMapper(), categoryId);
    }

    @Override
    public Long save(NewsModel newsModel) throws SQLException {
        StringBuilder sql = new StringBuilder("INSERT INTO news (title, thumbnail, shortDescription,");
        sql.append(" content, categoryId, createdAt, modifiedAt, createdBy, modifiedBy)");
        sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), newsModel.getTitle(), newsModel.getThumbnail(), newsModel.getShortDescription(), newsModel.getContent(),
                newsModel.getCategoryId(), newsModel.getCreatedAt(), newsModel.getModifiedAt(), newsModel.getCreatedBy(), newsModel.getModifiedBy());
    }

    @Override
    public void update(NewsModel newsModel) throws SQLException {
        StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?, shortDescription = ?,");
        sql.append(" content = ?, categoryId = ?, createdAt = ?, modifiedAt = ?, createdBy = ?, modifiedBy = ?)");
        sql.append(" WHERE id = ?");
        update(sql.toString(), newsModel.getTitle(), newsModel.getThumbnail(), newsModel.getShortDescription(), newsModel.getContent(),
                newsModel.getCategoryId(), newsModel.getCreatedAt(), newsModel.getModifiedAt(), newsModel.getCreatedBy(), newsModel.getModifiedBy(),
                newsModel.getId());
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM news WHERE id = ?";
        update(sql, id);
    }

    @Override
    public Integer getTotalItems() throws SQLException {
        String sql = "SELECT COUNT(*) FROM news";
        return count(sql);
    }
}
