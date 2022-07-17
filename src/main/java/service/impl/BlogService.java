package service.impl;

import model.Blog;
import model.Category;
import model.User;
import service.IBlogService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogService implements IBlogService {
    private final static String JDBC_URL = "jdbc:mysql://localhost:3306/blogpage?useSSL=false";
    private final static String JDBC_USERNAME = "root";
    private final static String JDBC_PASSWORD = "123456";
    private String sqlSelectAll = "SELECT * FROM blog inner join customers on blog.CustomerID = customers.CustomerID ;";
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

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
        List<Blog> blogs = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectAll)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("BlogID");
                String content = rs.getString("BlogContent");
                String title = rs.getString("BlogTitle");
                String img = rs.getString("ImageURL");
                Date create = rs.getDate("Time_Create");
                Date update = rs.getDate("Time_Update");
                boolean isStatus = rs.getBoolean("isActive");
                int customerID = rs.getInt("customers.CustomerID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String address = rs.getString("Address");
                String phone = rs.getString("PhoneNumber");
                String username = rs.getString("Username");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                Date createTime = rs.getDate("Create_Time");
                Date updateTime = rs.getDate("Update_Time");
                boolean isActive = rs.getBoolean("customers.isActive");
                User user = new User(customerID, firstName, lastName, address, phone, username, email, password, createTime, updateTime, isActive);

                blogs.add(new Blog(id, content, title, img,create, update, isActive, user));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return blogs;
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
