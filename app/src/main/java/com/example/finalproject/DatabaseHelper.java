/*Description:This program allows used to create  a valid user with username and password is is
later saved stored and used to login the application. After that it prompts a quiz app in which we can select the option
of radio buttons in which if you select the right answer that is stored in database  the text turns into green , in this process the high score and number of
question is tracked along with the different question. at the end the high score is displayed . and stored even when the app is closed.For this activity there is a animation screen of top and bottom animation in which top animation includes the image view and bottom
animation includes two text view with duration set to 3 seconds.The delay time is 4.5 seconds.I changed the default main activity shown to this custom activity, therefore this screen will be shown at
the beginning of this app.


Due Date:5/8/2020

*/

package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.finalproject.Quizlink.*;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String MyDatabase = "MyQuizDatabase.db";
    private static final int DB_VERSION = 7;                        // for updating purpose  like making changes in database.
    private SQLiteDatabase db;

    public DatabaseHelper(@Nullable Context context) {
        super(context, MyDatabase, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {                          //creating initial database.
        this.db = db;
        final String QUESTION_TABLE = "CREATE TABLE "+ Quizlink.MyQuestionTable.TABLE_NAME+ "("+ Quizlink.MyQuestionTable._ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+MyQuestionTable.QUESTION_COLUMN+ " TEXT, "
                + Quizlink.MyQuestionTable.ANSWER1_COLUMN + " TEXT, "+ Quizlink.MyQuestionTable.ANSWER2_COLUMN + " TEXT,"+ Quizlink.MyQuestionTable.RIGHT_ANSWER+ " INTEGER"+ ")";

        db.execSQL(QUESTION_TABLE);

        addingQuestions();


    }

    private void addingQuestions() {

        Myquestions myquestions = new Myquestions("Do you have any fever ?","Yes","No",1);
        addQ(myquestions);
        Myquestions myquestions1 = new Myquestions("Do you have any Sore throat ?","Yes","No",1);
        addQ(myquestions1);
        Myquestions myquestions2 = new Myquestions("Do you have any New cough ?","Yes","No",1);
        addQ(myquestions2);
        Myquestions myquestions3 = new Myquestions("Do you have any Headache ?","Yes","No",1);
        addQ(myquestions3);
        Myquestions myquestions4 = new Myquestions("Do you have any Diarrhea ?","Yes","No",1);
        addQ(myquestions4);
        Myquestions myquestions5 = new Myquestions("Have you had close contact with someone diagnosed with COVID-19 or been notified that you may have been exposed to it?\n" +
                "\n","Yes","No",1);
        addQ(myquestions5);

    }

    private void addQ(Myquestions myquestions){
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyQuestionTable.QUESTION_COLUMN,myquestions.getQuestion());
        contentValues.put(MyQuestionTable.ANSWER1_COLUMN,myquestions.getAnswer1());
        contentValues.put(MyQuestionTable.ANSWER2_COLUMN,myquestions.getAnswer2());

        contentValues.put(MyQuestionTable.RIGHT_ANSWER,myquestions.getRightanswer());
        db.insert(MyQuestionTable.TABLE_NAME,null,contentValues);

    }

    public List<Myquestions> gettingAllQuestions(){
        List<Myquestions> list_of_questions = new ArrayList<>();
        db = getReadableDatabase();
        Cursor mycursor = db.rawQuery("SELECT * FROM " + MyQuestionTable.TABLE_NAME,null);
        if (mycursor.moveToFirst()) {
            do {
                Myquestions myquestions = new Myquestions();
                myquestions.setQuestion(mycursor.getString(mycursor.getColumnIndex(MyQuestionTable.QUESTION_COLUMN)));
                myquestions.setAnswer1(mycursor.getString(mycursor.getColumnIndex(MyQuestionTable.ANSWER1_COLUMN)));
                myquestions.setAnswer2(mycursor.getString(mycursor.getColumnIndex(MyQuestionTable.ANSWER2_COLUMN)));

                myquestions.setRightanswer(mycursor.getInt(mycursor.getColumnIndex(MyQuestionTable.RIGHT_ANSWER)));

                list_of_questions.add(myquestions);


            } while (mycursor.moveToNext());
        }
        mycursor.close();
        return list_of_questions;


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+MyQuestionTable.TABLE_NAME);
        onCreate(db);

    }
}
