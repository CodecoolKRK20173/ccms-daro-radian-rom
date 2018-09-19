package com.codecool.model.staff;

public class Staff {
    String id;
    String name;
    String surname;
    String email;
    String type;

    public Staff(String id, String name, String surname, String email, String type) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(String type) {
        this.type = type;
    }
}
