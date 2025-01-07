package com.coding;

import com.coding.Difficulty;

import java.util.ArrayList;
import java.util.List;

public class Question {

    static int question_cnt=0;
    Difficulty difficulty;
    int question_id;
    int score;

    public Question(Difficulty difficulty, int score) {
        question_cnt++;
        this.difficulty = difficulty;
        this.question_id = question_cnt;
        this.score = score;
    }


    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public int getScore() {
        return score;
    }


    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @java.lang.Override
    public String toString() {
        return "Question{" +
                "difficulty=" + difficulty +
                ", question_id=" + question_id +
                ", score=" + score +
                '}';
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public void setScore(int score) {
        this.score = score;
    }




}
