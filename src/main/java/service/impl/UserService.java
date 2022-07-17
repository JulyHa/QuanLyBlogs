package service.impl;

import service.IUserService;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {

    private final static String JDBC_URL = "jdbc:mysql://localhost:3306/blogpage?useSSL=false";
    private final static String JDBC_USERNAME = "root";
    private final static String JDBC_PASSWORD = "123456";

    private String sqlSelectById = "select * from customers INNER JOIN account_role " +
            "on customers.customerID = account_role.customerID " +
            "where customers.CustomerID = ? and RoleId = ?;";
    private String sqlSelectByUser = "select * from customers INNER JOIN account_role " +
            "on customers.customerID = account_role.customerID " +
            "where( username = ? or email = ? ) and password = ? and RoleId = ?; ";
    private String sqlSelectAll = "select * from customers;";
    private String sqlInsert = "INSERT INTO customers (`FirstName`, `LastName`, `Address`, `PhoneNumber`, `Username`, `Email`, `Password`, `Create_Time`, `Update_Time`, `isActive`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private String sqlInsertRole = "INSERT INTO account_role (CustomerID, RoleId) VALUES (?, 1);";
    private String sqlUpdate = "UPDATE customers SET FirstName = ?, LastName = ?, Address = ?, PhoneNumber = ?, Username = ?," +
                                " Email = ?, Password = ?, Update_Time = ?, isActive = ? WHERE (CustomerID = ?);";
    private String sqlDelete = "delete from customers where CustomerID = ?;";
    private String sqlDeleteRole = "delete from account_role where CustomerID = ?;";

    public UserService() {
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
    public void insert(User user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement pre = connection.prepareStatement(sqlInsert)) {
            pre.setString(1, user.getFirstName());
            pre.setString(2, user.getLastName());
            pre.setString(3, user.getAddress());
            pre.setString(4, user.getPhoneNumber());
            pre.setString(5, user.getUsername());
            pre.setString(6, user.getEmail());
            pre.setString(7, user.getPassword());
            pre.setDate(8, new Date(new java.util.Date().getDate()));
            pre.setDate(9,new Date(new java.util.Date().getDate()));
            pre.setBoolean(10, user.isStatus());

            System.out.println(pre);
            pre.executeUpdate();
        }
        try(Connection con = getConnection(); PreparedStatement pre = con.prepareStatement(sqlSelectByUser)) {
            pre.setInt(1, user.getId());
            pre.executeUpdate();
        }
    }

    @Override
    public User selectById(int id, int role) throws SQLException {
        User user = null;
        try(Connection con = getConnection();
        PreparedStatement pre = con.prepareStatement(sqlSelectById)){
            pre.setInt(1, id);
            pre.setInt(2, role);
            ResultSet rs = pre.executeQuery();


            while (rs.next()){
                int customerID = rs.getInt("CustomerID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String address = rs.getString("Address");
                String phone = rs.getString("PhoneNumber");
                String username = rs.getString("Username");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                Date createTime = rs.getDate("Create_Time");
                Date updateTime = rs.getDate("Update_Time");
                boolean isActive = rs.getBoolean("isActive");

                user = new User(customerID, firstName, lastName, address, phone, username, email, password, createTime, updateTime, isActive);
            }

        }
        return user;
    }

    @Override
    public int selectByNameAndPass(String name, String password, int role) {
        User u = null;
        try(Connection con = getConnection();
            PreparedStatement pre = con.prepareStatement(sqlSelectByUser)){
            pre.setString(1, name);
            pre.setString(2, name);
            pre.setString(3, password);
            pre.setInt(4, role);
            ResultSet rs =pre.executeQuery();

            while (rs.next()){
                String username = rs.getString("username");
                String pass = rs.getString("password");
                u = new User(username, pass);
            }
            if(u != null){
                return role;
            }
        }catch (SQLException e){
            return -1;
        }
        return -1;
    }

    @Override
    public List<User> selectAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectAll)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("CustomerID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String address = rs.getString("Address");
                String phone = rs.getString("PhoneNumber");
                String username = rs.getString("Username");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                Date createTime = rs.getDate("Create_Time");
                Date updateTime = rs.getDate("Update_Time");
                boolean isActive = rs.getBoolean("isActive");

                users.add(new User(id,firstName, lastName, address, phone, username, email, password, createTime, updateTime, isActive));
            }
        } catch (SQLException e) {
//            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDelete = false;
        try(Connection connection = getConnection();
                                       PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete)) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete)){
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }

        return rowDelete;
    }

    @Override
    public boolean update(User user) throws SQLException {
        boolean updateRow = false;
        try(Connection connection = getConnection();
            PreparedStatement pre = connection.prepareStatement(sqlUpdate)) {
            pre.setString(1, user.getFirstName());
            pre.setString(2, user.getLastName());
            pre.setString(3, user.getAddress());
            pre.setString(4, user.getPhoneNumber());
            pre.setString(5, user.getUsername());
            pre.setString(6, user.getEmail());
            pre.setString(7, user.getPassword());
            pre.setDate(8, new Date(new java.util.Date().getDate()));
            pre.setBoolean(9, user.isStatus());
            pre.setInt(10, user.getId());
            updateRow = pre.executeUpdate() > 0;

        }catch (Exception e){

        }
        return updateRow;
    }
}
