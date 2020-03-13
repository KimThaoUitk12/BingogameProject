package com.example.demo.model;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@RestResource
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String birthDay;
    private long badgeNumber;
    private String image;

    public Integer getId() {
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
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public long getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(long badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public Employee(Integer id, String name, String email, String birthDay, long badgeNumber, String image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDay = birthDay;
        this.badgeNumber = badgeNumber;
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
