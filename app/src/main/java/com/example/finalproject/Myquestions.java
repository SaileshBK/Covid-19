/* This class contains the information different answer options and correct answer of the questions, and it will be stored in the database*/

package com.example.finalproject;

public class Myquestions {
    private String Question;
    private String answer1;
    private String answer2;

    private int rightanswer;

    public Myquestions(){

    }  //This is just a empty constructor for database.

    public Myquestions(String question, String answer1, String answer2, int rightanswer) {
        Question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;

        this.rightanswer = rightanswer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }




    public int getRightanswer() {
        return rightanswer;
    }

    public void setRightanswer(int rightanswer) {
        this.rightanswer = rightanswer;
    }
}
