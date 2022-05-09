/*This class is the container for different constance for sqLite operations.
This is important because this class makes it easier to make changes in database example: our column name*/


package com.example.finalproject;

import android.provider.BaseColumns;

public final class Quizlink {                                   //final because for sub classes


    public static class MyQuestionTable implements BaseColumns {
        public static final String TABLE_NAME = "questions_table";
        public static final String QUESTION_COLUMN = "questions";
        public static final String ANSWER1_COLUMN = "answer1";
        public static final String ANSWER2_COLUMN = "answer2";
        public static final String ANSWER3_COLUMN = "answer3";
        public static final String ANSWER4_COLUMN = "answer4";
        public static final String RIGHT_ANSWER = "answer";


    }



}
