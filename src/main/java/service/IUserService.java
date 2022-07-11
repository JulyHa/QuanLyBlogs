package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public void insert(User user) throws SQLException;

    public User selectById(int id) throws SQLException;

    public boolean selectByNameAndPass(String name, String password);

    public List<User> selectAll();

    public boolean delete(int id) throws SQLException;

    public boolean update(User user) throws SQLException;
}
