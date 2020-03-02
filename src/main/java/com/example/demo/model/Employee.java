package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    private Integer id;

    private String name;
    private String email;
    private String BirthDay;
    private long BadgeNumber;
    private String image;


    public long getId() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(String birthDay) {
        BirthDay = birthDay;
    }

    public long getBadgeNumber() {
        return BadgeNumber;
    }

    public void setBadgeNumber(long badgeNumber) {
        BadgeNumber = badgeNumber;
    }

    public Employee(int id, String name, String email, String birthDay, long badgeNumber, String image) {
        this.id = id;
        this.name = name;
        this.email = email;
        BirthDay = birthDay;
        BadgeNumber = badgeNumber;
        this.image = image;
    }

    public Employee() { }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
