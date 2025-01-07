package com.coding;
import java.util.*;

public class UserSort implements Comparator<User> {

    public  int compare(User u1, User u2) {
        return u1.getRating()-u2.getRating();
    }
}
