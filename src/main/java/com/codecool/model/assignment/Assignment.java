package com.codecool.model.assignment;

public class Assignment {
    private String id;
    private String name;
    private String mentor;
    private String description;

    public Assignment(String id, String name, String mentor, String description) {
        this.id = id;
        this.name = name;
        this.mentor = mentor;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMentor() {
        return mentor;
    }

    public String getDescription() {
        return description;
    }
}
