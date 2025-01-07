package com.coding;
import java.util.Map.Entry;
import java.util.*;
public class Main {
    public static void main(String[] args) {

//        CreateUser Ross
//        CreateUser Monica
//        CreateUser Joey
//        CreateUser Chandler

        UserService.addUser("Ross");
        UserService.addUser("Monica");
        UserService.addUser("Joey");
        UserService.addUser("Chandler");
        UserService.getLeaderboard("Asc");

        ContestManager c= new ContestManager();
        c.addQuestion(Difficulty.LOW,17);
        c.addQuestion(Difficulty.LOW,20);
        c.addQuestion(Difficulty.LOW,25);
        c.addQuestion(Difficulty.LOW,30);
        c.addQuestion(Difficulty.MEDIUM,40);
        c.addQuestion(Difficulty.MEDIUM,50);
        c.addQuestion(Difficulty.MEDIUM,59);
        c.addQuestion(Difficulty.MEDIUM,70);
        c.addQuestion(Difficulty.HIGH,80);
        c.addQuestion(Difficulty.HIGH,85);
        c.addQuestion(Difficulty.HIGH,89);
        c.addQuestion(Difficulty.HIGH,90);


        c.listQuestions();
        c.listQuestions(Difficulty.LOW);
        c.listQuestions(Difficulty.HIGH);
        c.listQuestions(Difficulty.MEDIUM);

        c.addContest("Codechef Starter",Difficulty.MEDIUM,"Ross");
        c.attendContest("Monica",1);
        c.attendContest("Joey", 1);
        c.attendContest("Chandler",1);

        c.attendContest("Monica",2);
        c.runContest(1,"Ross");
        UserService.getLeaderboard("Asc");

        c.listContest();
        c.contestHistory(1);
        UserService.getLeaderboard("Dsc");


    }
}