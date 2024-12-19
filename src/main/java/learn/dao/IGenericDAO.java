package learn.dao;

import learn.mapper.IRowMapper;

import java.sql.SQLException;
import java.util.List;

public interface IGenericDAO<T> {
    <T> List<T> query(String sql, IRowMapper<T> rowMapper, Object... params) throws SQLException;
    void update(String sql, Object... params) throws SQLException;
    Long insert(String sql, Object... params) throws SQLException;
    int count(String sql, Object... params) throws SQLException;
}
