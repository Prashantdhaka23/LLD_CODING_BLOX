package com.coding;

import java.util.Objects;

public class User  implements Comparable<User> {

    String name;
    int rating;

    public User(String name) {
        this.name = name;
        this.rating=1500;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    public int compareTo(User o){
        return this.rating-o.getRating();
    }


}
