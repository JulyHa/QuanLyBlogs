package service.impl;

import model.Category;
import service.ICategoryService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService {
    private final static String JDBC_URL = "jdbc:mysql://localhost:3306/blogpage?useSSL=false";
    private final static String JDBC_USERNAME = "root";
    private final static String JDBC_PASSWORD = "123456";
    private String sqlSelectAll = "select * from categories;";
    private String sqlInsert = "INSERT INTO categories (CategoryName, Description, isActive) " +
                    "VALUES (?, ?, ?);";
    private String sqlUpdate = "UPDATE categories SET CategoryName = ?, Description = ? WHERE (CategoryID = ?);";
    private String sqlDelete = "delete from categories where CategoryID = ?;";
    private String sqlSelectById = "select * from categories where CategoryID = ?;";


    public CategoryService() {
    }

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
    public void insert(Category category) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement pre = connection.prepareStatement(sqlInsert)) {
            pre.setString(1, category.getName());
            pre.setString(2, category.getDescription());
            pre.setBoolean(3, category.isActive());

            System.out.println(pre);
            pre.executeUpdate();
        }
    }

    @Override
    public Category selectById(int id) throws SQLException {
        Category category = null;
        try(Connection con = getConnection();
            PreparedStatement pre = con.prepareStatement(sqlSelectById)){
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();


            while (rs.next()){
                int categoryID = rs.getInt("categoryID");
                String name = rs.getString("categoryName");
                String des = rs.getString("description");
                Boolean isActive = rs.getBoolean("isActive");

                category = new Category(categoryID,name, des, isActive);
            }

        }catch (SQLException e){

        }
        return category;
    }

    @Override
    public List<Category> selectByIsStatus() {
        return null;
    }

    @Override
    public List<Category> selectAll() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectAll)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("CategoryID");
                String name = rs.getString("CategoryName");
                String des = rs.getString("Description");
                boolean isActive = rs.getBoolean("isActive");

                categories.add(new Category(id, name, des, isActive));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDelete = false;
        try(Connection con = getConnection();
        PreparedStatement pre = con.prepareStatement(sqlDelete)) {
            pre.setInt(1, id);
            rowDelete = pre.executeUpdate() > 0;
        }
        return rowDelete;
    }

    @Override
    public boolean update(Category category) throws SQLException {
        boolean updateRow = false;
        try(Connection connection = getConnection();
            PreparedStatement pre = connection.prepareStatement(sqlUpdate)) {
            pre.setString(1, category.getName());
            pre.setString(2, category.getDescription());
//            pre.setBoolean(3, category.isActive());
            pre.setInt(3, category.getId());

            updateRow = pre.executeUpdate() > 0;

        }catch (Exception e){

        }
        return updateRow;
    }
}
