package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements Dialoggingv1.DialogListener {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button = findViewById(R.id.accept);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }



    public void openDialog() {
        Dialoggingv1 newDialog = new Dialoggingv1();
        newDialog.show(getSupportFragmentManager(), "my Dialog");

    }

    @Override
    public void onYesClicked() {
        Intent access2 = new Intent(SecondActivity.this, MainActivity2.class);
        startActivity(access2);

    }
}
