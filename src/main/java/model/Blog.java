package model;

import java.util.Date;
import java.util.zip.DataFormatException;

public class Blog {
    private int id;
    private String content;
    private String title;
    private String imageURL;
    private Date createTime;
    private Date updateTime;
    private boolean isActive;
    private User userID;

    public Blog() {
    }

    public Blog(int id, String content, String title, String imageURL, Date createTime, Date updateTime, boolean isActive, User userID) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.imageURL = imageURL;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isActive = isActive;
        this.userID = userID;
    }

    public Blog(String content, String title, String imageURL, Date createTime, Date updateTime, boolean isActive, User userID) {
        this.content = content;
        this.title = title;
        this.imageURL = imageURL;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isActive = isActive;
        this.userID = userID;
    }

    public Blog(String content, String title, String imageURL, boolean isActive, User userID) {
        this.content = content;
        this.title = title;
        this.imageURL = imageURL;
        this.isActive = isActive;
        this.createTime = new Date();
        this.updateTime = new Date();
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }
}
