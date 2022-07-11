package service.impl;

import model.Blog;
import service.IBlogService;

import java.sql.SQLException;
import java.util.List;

public class BlogService implements IBlogService {
    @Override
    public void insert(Blog blog) throws SQLException {
        
    }

    @Override
    public Blog selectById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Blog> selectByIsStatus() {
        return null;
    }

    @Override
    public List<Blog> selectAll() {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Blog blog) throws SQLException {
        return false;
    }
}
