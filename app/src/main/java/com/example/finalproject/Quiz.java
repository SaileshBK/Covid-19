package com.example.finalproject;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Quiz extends AppCompatActivity {

    public static final String High_score = "highscore";
    public static final String Status = "status";


    private long timeleft;
    private ColorStateList deftxtcolor2;


    private TextView tvQuestion,tvScore,tvQuestionCount,tvCountdown;
    private RadioGroup radioGroup;
    private RadioButton radioButton1,radioButton2,radioButton3,radioButton4;
    private Button checkbutton;
    private ColorStateList deftxtcolor;
    private List<Myquestions> myquestionsList;
    private int questioncount,questiontotal;

    private Myquestions currentQuest;
    private int score;
    private boolean answered;

    private long backpresstime;

    private Spinner spinner;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvQuestion  = findViewById(R.id.questiontextview);
        tvQuestionCount = findViewById(R.id.questioncount);
        tvScore = findViewById(R.id.scorecount);
        radioGroup = findViewById(R.id.radiogroup);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        checkbutton = findViewById(R.id.buttoncheck);

        deftxtcolor = radioButton1.getTextColors();








        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        myquestionsList = databaseHelper.gettingAllQuestions();
        questiontotal = myquestionsList.size();                          // size of our total question list
        Collections.shuffle(myquestionsList);
        nextQuestion();

        checkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (radioButton1.isChecked()||radioButton2.isChecked()){
                        answerCheck();
                    }else {
                        Toast.makeText(Quiz.this,"Select an answer",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    nextQuestion();
                }
            }
        });
        




    }




    private void nextQuestion() {
        radioButton1.setTextColor(deftxtcolor);
        radioButton2.setTextColor(deftxtcolor);
        radioGroup.clearCheck();
        if (questioncount < questiontotal) {
            currentQuest = myquestionsList.get(questioncount);
            tvQuestion.setText(currentQuest.getQuestion());
            radioButton1.setText(currentQuest.getAnswer1());
            radioButton2.setText(currentQuest.getAnswer2());


            questioncount++;
            tvQuestionCount.setText("Question: "+questioncount+ "/"+questiontotal);
            answered = false;
            checkbutton.setText("Confirm");

            Intent intent= getIntent();
















        }else {
            endquiz();
        }

    }





    private void answerCheck(){
        answered = true;
        RadioButton selectradio = findViewById(radioGroup.getCheckedRadioButtonId());
        int answer_number = radioGroup.indexOfChild(selectradio)+1;
        if (answer_number == currentQuest.getRightanswer()) {
            score++;

        }
        
        displaySolution();

    }

    private void displaySolution() {
        switch (currentQuest.getRightanswer()){
            case 1:
                tvQuestion.setText("Please click NEXT!");
                break;
            case 2:
                tvQuestion.setText("Please click NEXT!");
                break;


        }
        if (questioncount < questiontotal){
            checkbutton.setText("Next");
        }else{
            checkbutton.setText("Finish");
        }

    }

    private void endquiz() {
        Intent intent = new Intent();
        intent.putExtra(High_score,score);

        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public void onBackPressed() {                                    // This creates a method in which when user back pressed 2 times within 1 and half second in the middle of the quiz we can still save the high score attempted.
        if (backpresstime+3000 > System.currentTimeMillis()){
            endquiz();
        }else {
            Toast.makeText(this,"press back again to finish the Quiz",Toast.LENGTH_SHORT).show();
        }
        backpresstime = System.currentTimeMillis();

    }




}
