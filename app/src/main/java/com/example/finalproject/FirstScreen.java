/*Description:For this activity there is a animation screen of top and bottom animation in which top animation includes the image view and bottom
               animation includes two text view with duration set to 3 seconds.The delay time is 4.5 seconds.I changed the default main activity shown to this custom activity, therefore this screen will be shown at
               the beginning of this app.

*/

package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstScreen extends AppCompatActivity {
    private static int SPLASH_SCREEN = 4600;

    Animation topanimation,bottomanimation;
    ImageView imageView;
    TextView welcome,pname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_first_screen);


        topanimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        imageView = findViewById(R.id.quizimage);
        welcome = findViewById(R.id.welcome);
        pname = findViewById(R.id.pname);



        imageView.setAnimation(topanimation);
        welcome.setAnimation(bottomanimation);
        pname.setAnimation(bottomanimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(FirstScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);


    }
}
