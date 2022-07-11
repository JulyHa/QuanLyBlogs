package model;

import java.util.Date;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String username;
    private String email;
    private String password;
    private Date createTime;
    private Date updateTime;
    private boolean status;

    public User() {
    }

    public User(String name, String password){
        this.username = name;
        this.password = password;
    }

    public User(int id, String firstName, String lastName, String address, String phoneNumber, String username, String email, String password, Date updateTime) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.email = email;
        this.password = password;
        this.updateTime = updateTime;
    }

    public User(int id, String firstName, String lastName, String address, String phoneNumber, String username, String email, String password, Date createTime, Date updateTime, boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = isActive;
    }

    public User(int id, String firstName, String lastName, String address, String phoneNumber, String username, String email, String password, boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createTime = new Date();
        this.updateTime = new Date();
        this.status = isActive;
    }

    public User(String firstName, String lastName, String address, String phoneNumber, String username, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createTime = new Date();
        this.updateTime = new Date();
        this.status = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setActive(boolean active) {
        status = active;
    }
}
