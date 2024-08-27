package com.example.job.listings.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String company;
    private String location;
    private String description;

    public void setId(Long id) {
     this.id=id;
    };
    public void setLocation(String location) {
        this.location=location;
    };
    public void setCompany(String company) {
        this.company=company;
    } public void setTitle(String title) {
        this.title=title;
    } public void setdescription(String description) {
        this.description=description;
    }
    public Long getId() {
        return id;
    };
    public String getTitle(){
        return title;
    }
    public String getCompany(){
        return company;
    }
    public String getLocation(){
        return location;
    }
    public String getDescription(){
        return description;
    }


}
