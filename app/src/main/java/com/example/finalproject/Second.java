package com.example.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Second extends AppCompatActivity {

    private static final int REQUEST_CODE_FOR_QUIZ = 1;
    public static final String PREFS2 = "PREFS2";
    public static final String Highscore_key = "HighScoreKey";
    public static final String DIFF = "difficulty";
    private int highscore;
    TextView displayuser,HighScore,status,status2,status3,status4,status5,status6,status7;
    Button startquiz,endquiz;



    private ArrayList<String> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizmain);

        startquiz = findViewById(R.id.startquiz);
        endquiz = findViewById(R.id.endquiz);
        status = findViewById(R.id.status);
        status2 = findViewById(R.id.status2);
        status3 = findViewById(R.id.status3);
        status4 = findViewById(R.id.status4);
        status5 = findViewById(R.id.status5);
        status6 = findViewById(R.id.status6);
        status7 = findViewById(R.id.status7);
        endquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endquiz();
            }
        });







        startquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startquiz();

            }
        });

        SharedPreferences preferences = getSharedPreferences("PREFS",MODE_PRIVATE);
        String user = preferences.getString("user","");// This "user" is key for the user display in second page when logged in.

        //HighScore = findViewById(R.id.score);
        //FirstHighScore();


    }

    private void endquiz() {
        Intent intent= new Intent(Second.this,MainActivityForNavigation.class);


        startActivity(intent);
    }


    private void startquiz() {

        Intent intent= new Intent(Second.this,Quiz.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("myresult",result);
        intent.putExtras(bundle);


        startActivityForResult(intent,REQUEST_CODE_FOR_QUIZ);                                                   // This startActivityForResult will provide us our score at the end of the quiz

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE_FOR_QUIZ){
            if (resultCode==RESULT_OK){
                int myscore  = data.getIntExtra(Quiz.High_score,0);
                if (myscore > 3){

                    status.setText("Your answers indicate that you should call your health care provider and describe your symptoms and/or your contact with someone who’s been diagnosed.");
                    status2.setText("Be sure to indicate if you:");
                    status3.setText("1. Are 65 or older.");
                    status4.setText("2. Suffer from a chronic health problem, such as diabetes, heart disease, cancer or lung disease.");
                    status5.setText("3. A health care or emergency worker who has been interacting with patients who may have COVID-19.");
                    status6.setText("4. Are immunocompromised, such as people with HIV/AIDS and cancer.");
                    status7.setText("5. Are pregnant, or had a baby within the last 2 weeks.");


                }
                else {
                    status.setText("Your answers indicate you are at low risk for COVID-19 at this time. However, you should protect yourself and others from the spread of COVID-19.");
                    status2.setText("");
                    status3.setText("");
                    status4.setText("");
                    status5.setText("");
                    status6.setText("");
                    status7.setText("");

                }


            }
        }


    }



    private void updateScore(int myscore) {

        highscore = myscore;
        HighScore.setText("Highscore: "+ highscore);
        SharedPreferences mypref = getSharedPreferences(PREFS2,MODE_PRIVATE);
        SharedPreferences.Editor editor2 = mypref.edit();
        editor2.putInt(Highscore_key,highscore);
        editor2.apply();


    }


}
