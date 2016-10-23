package com.lc.giftthecode.volunteer;

public class SearchResults {
    private String name = "";
    private String Food = "";
    private String location = "";
    private String time = "";

    public void setDonorName(String name) {
        this.name = name;
    }

    public String getDonorName() {
        return name;
    }

    public void setFood(String Food) {
        this.Food = Food;
    }

    public String getFood() {
        return Food;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getTime(){
        return time;
    }
}