package model;

public class Category {
    private int id;
    private String name;
    private String description;
    private boolean status;

    public Category() {
    }

    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Category(int id, String name, String description, boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = isActive;
    }

    public Category(String name, String description, boolean isActive) {
        this.name = name;
        this.description = description;
        this.status = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return status;
    }

    public void setActive(boolean active) {
        status = active;
    }
}
