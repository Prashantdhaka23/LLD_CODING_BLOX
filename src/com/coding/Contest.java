package com.coding;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class Contest {
    private List<Question> questions;
    private Difficulty difficulty;
    private int contest_id;
    private User creater;
    private String name;

    private boolean isActive;

    private List<User> participants;

    private Map<User,List<Integer> > solvedQuestionListByUser;
    private Map<User,Integer> score;

    static int contest_num=1;

    public Contest(String name,List<Question> questions, Difficulty difficulty, User creater) {
        this.contest_id=contest_num;
        this.name=name;
        this.questions = questions;
        this.difficulty = difficulty;
        this.creater = creater;
        this.participants = new ArrayList<>();
        this.isActive=true;
        solvedQuestionListByUser=new HashMap<>();
        score=new HashMap<>();
        contest_num++;
    }

    public void addParticipant(String user) {

        if(!UserService.isUserExist(user)){
            System.out.println("User dose not exist");
        }

        User u=UserService.getUser(user);
        if(!participants.contains(UserService.getUser(user))) {
            participants.add(u);
        }

    }

    public int getContest_id() {
        return contest_id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public User getCreater() {
        return creater;
    }

    public void setCreater(User creater) {
        this.creater = creater;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public List<User> getParticipants() {
        return participants;
    }
    public String getCreaterName(){
         return creater.getName();
    }

    @java.lang.Override
    public String toString() {
        return "Contest{" +
                "difficulty=" + difficulty +
                ", contest_id=" + contest_id +
                ", creater=" + creater +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public Map<User, List<Integer>> getSolvedQuestionListByUser() {
        return solvedQuestionListByUser;
    }

    public Map<User, Integer> getScore() {
        return score;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setSolvedQuestionListByUser(Map<User, List<Integer>> solvedQuestionListByUser) {
        this.solvedQuestionListByUser = solvedQuestionListByUser;
    }

    public void setScore(Map<User, Integer> score) {
        this.score = score;
    }
}
