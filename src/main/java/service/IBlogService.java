package service;

import model.Blog;
import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface IBlogService {

    public void insert(Blog blog) throws SQLException;

    public Blog selectById(int id) throws SQLException;

    public List<Blog> selectByIsStatus();

    public List<Blog> selectAll();

    public boolean delete(int id) throws SQLException;

    public boolean update(Blog blog) throws SQLException;
}
