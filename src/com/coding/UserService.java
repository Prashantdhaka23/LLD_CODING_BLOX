package com.coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserService {

    private static final List<User> users=new ArrayList<>();;
    private static final List<String> userNames=new ArrayList<>();

    public UserService() {

    }

    public static void addUser(String name) {
        if(isUserExist(name)) return;
        User u=new User(name);
        userNames.add(name);
        users.add(u);
    }

    public List<User> getUsers() {
        return users;
    }
    public static boolean isUserExist(String user) {
        return userNames.contains(user);
    }
    public static User getUser(String user) {
        return users.get(userNames.indexOf(user));
    }

    public static void getLeaderboard(String order) {
        System.out.println("-------Leaderboard------");

        if(order.equalsIgnoreCase("Asc")){

             Collections.sort(users, new UserSort());

        }else{

             users.sort(Comparator.reverseOrder());
        }

        for(User u : users){
            System.out.println(u.getName()+" :" + u.getRating());
        }

    }
}
