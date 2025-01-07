package com.coding;

import java.util.*;
import java.util.List;
import java.util.ArrayList;


public class ContestManager {

     private final List<Question> lowDiffQuestions;
     private final List<Question> mediumDifficultyQuestions;
     private final List<Question> highDifficultyQuestions;
     private final List<Contest> contests;
     public ContestManager() {
         contests = new ArrayList<>();
         lowDiffQuestions = new ArrayList<>();
         mediumDifficultyQuestions = new ArrayList<>();
         highDifficultyQuestions = new ArrayList<>();
     }

     public void addQuestion(Difficulty diff , int score) {
         if(Difficulty.LOW==diff){
             lowDiffQuestions.add(new Question(Difficulty.LOW,score));
         }
         else if(Difficulty.MEDIUM==diff){
             mediumDifficultyQuestions.add(new Question(Difficulty.MEDIUM,score));
         }
         else if(Difficulty.HIGH==diff){
             highDifficultyQuestions.add(new Question(Difficulty.HIGH,score));
         }
     }

     public void addContest(String name , Difficulty difficulty, String creater) {
         if(!UserService.isUserExist(creater)){
             System.out.println("User does not exist");
             return;
         }
         List<Question> questions=getQuestion(difficulty);
         User user=UserService.getUser(creater);
         Contest c=new Contest(name,questions,difficulty,user);
         c.addParticipant(creater);
         this.contests.add(c);
     }

     private List<Question> getQuestion(Difficulty difficulty) {
         if(Difficulty.LOW==difficulty){
             return lowDiffQuestions;
         }
         else if(Difficulty.MEDIUM==difficulty){
             return mediumDifficultyQuestions;
         }
         else if(Difficulty.HIGH==difficulty){
             return highDifficultyQuestions;
         }
         return null;
     }

     public void listQuestions(){

         for(Question q: lowDiffQuestions){
             System.out.println(q.toString());
         }
         for(Question q: mediumDifficultyQuestions){
             System.out.println(q.toString());
         }
         for(Question q: highDifficultyQuestions){
             System.out.println(q.toString());
         }

     }
     public void listQuestions(Difficulty difficulty) {

         List<Question> listQuestion;

         if(Difficulty.LOW==difficulty){
             listQuestion=lowDiffQuestions;
         }
         else if(Difficulty.MEDIUM==difficulty){
             listQuestion=mediumDifficultyQuestions;
         }
         else if(Difficulty.HIGH==difficulty){
             listQuestion=highDifficultyQuestions;
         }else{
             listQuestion= new ArrayList<>();
         }

         for(Question q: listQuestion){
             System.out.println(q.toString());
         }

     }


     public void attendContest(String user, int contest_id) {


         for(Contest c : contests){
             if(c.getContest_id()==(contest_id)){
                 if(c.isActive()) {
                     c.addParticipant(user);
                 }else{
                     System.out.println("Contest end!");
                 }
                 return ;
             }
         }

         System.out.println("Contest does not exist");

     }

     public void runContest(int contest_id , String creater ) {

         for(Contest c:contests) {
             if (c.getContest_id()==(contest_id) && c.getCreaterName().equals(creater)){
                   this.getParticipantsScore(c);
                   c.setActive(false);
             }
         }
     }
     public void getParticipantsScore(Contest c) {
         List<User> participants = c.getParticipants();
         List<Question> q = c.getQuestions();
         List<Integer> scores = new ArrayList<>();
         Map<User,List<Integer>> solvedQuestionByUser=new HashMap<>();
         Map<User,Integer> Score=new HashMap<>();
         for (User user : participants) {
             int userScore = 0;
             solvedQuestionByUser.put(user,new ArrayList<>());
             for (Question q1 : q) {
                 int sc = q1.getScore();
                 int random = (int) (Math.random() * 100);

                 if (random % 2 == 0) {
                     solvedQuestionByUser.get(user).add(q1.getQuestion_id());
                     userScore += sc;
                 }
             }
             scores.add(userScore);
             Score.put(user,userScore);
         }
         c.setSolvedQuestionListByUser(solvedQuestionByUser);
         c.setScore(Score);
         this.updateScores(participants,scores,c.getDifficulty());

     }

     private void  updateScores(List<User> participants , List<Integer> scores ,Difficulty difficulty){

       for(int i=0;i<participants.size();i++){
           User user=participants.get(i);
           int score=scores.get(i);
           if(difficulty==Difficulty.LOW){
               user.setRating(user.getRating()+score-50);
           }else if(difficulty==Difficulty.MEDIUM){
               user.setRating(user.getRating()+score-30);
           }else if(difficulty==Difficulty.HIGH){
               user.setRating(user.getRating()+score);
           }
       }
     }

    public void listContest(){
        for(Contest c : contests ){
            System.out.println(c.toString());
        }
    }


    public void contestHistory(int contest_id){

         for(Contest c :contests){
             if(c.getContest_id()==contest_id){
                 Map<User,List<Integer>> questionSolvedByUser= c.getSolvedQuestionListByUser();
                 Map<User,Integer> score=c.getScore();

                 for(Map.Entry<User,List<Integer>> m :questionSolvedByUser.entrySet() ){
                      User u=m.getKey();
                      List<Integer> l=m.getValue();
                      System.out.print(u.getName()+ ": ");
                      System.out.print(score.get(u));
                      System.out.println(l);


                 }


             }
         }
    }



}

