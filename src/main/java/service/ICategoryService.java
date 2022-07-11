package service;

import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryService {

    public void insert(Category category) throws SQLException;

    public Category selectById(int id) throws SQLException;

    public List<Category> selectByIsStatus();

    public List<Category> selectAll();

    public boolean delete(int id) throws SQLException;

    public boolean update(Category category) throws SQLException;
}
