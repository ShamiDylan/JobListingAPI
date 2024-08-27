package com.example.job.listings.DTOs;



public class JobDto {

    private String title;
    private String company;
    private String location;
    private String description;


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
