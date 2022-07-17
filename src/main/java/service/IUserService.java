package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public void insert(User user) throws SQLException;

    public User selectById(int id, int role) throws SQLException;

    public int selectByNameAndPass(String name, String password, int role);

    public List<User> selectAll();

    public boolean delete(int id) throws SQLException;

    public boolean update(User user) throws SQLException;
}
