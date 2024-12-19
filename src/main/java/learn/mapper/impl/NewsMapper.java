package learn.mapper.impl;

import learn.mapper.IRowMapper;
import learn.model.NewsModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsMapper implements IRowMapper<NewsModel> {

    @Override
    public NewsModel mapRow(ResultSet rs) {
        try {
            NewsModel newsModel = new NewsModel();
            newsModel.setId(rs.getLong("id"));
            newsModel.setTitle(rs.getString("title"));
            newsModel.setThumbnail(rs.getString("thumbnail"));
            newsModel.setShortDescription(rs.getString("shortDescription"));
            newsModel.setContent(rs.getString("content"));
            newsModel.setCategoryId(rs.getLong("categoryId"));
            newsModel.setCreatedAt(rs.getTimestamp("createdAt"));
            if (rs.getTimestamp("modifiedAt") != null) {
                newsModel.setModifiedAt(rs.getTimestamp("modifiedAt"));
            }
            newsModel.setCreatedBy(rs.getString("createdBy"));
            if (rs.getString("modifiedBy") != null) {
                newsModel.setModifiedBy(rs.getString("modifiedBy"));
            }
            return newsModel;
        } catch (SQLException e) {
            return null;
        }
    }
}
