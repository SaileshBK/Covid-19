/* Name:MainActivity.java
   Due Date:3/30/2020
   Description: This is the main java file which works as a medium to transfer data between Firstfragment to SecondFragment.
    Here a method is created called onDataSend which sends the string to second fragment .



*/


package com.example.finalproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity2 extends AppCompatActivity implements FirstFragment.OnDataSendListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        if (findViewById(R.id.fragmentcontainer) !=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }

            FirstFragment firstFragment = new FirstFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentcontainer,firstFragment,null).commit();
        }
    }

    @Override
    public void onDataSend(String mdata, String m1data, String m2data, String m3data, String m4data, String m5data, String m6data, String m7data, String bd) {
        SecondFragment secondFragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString("message",mdata);
        bundle.putString("message2",m1data);
        bundle.putString("message3",m2data);
        bundle.putString("message4",m3data);
        bundle.putString("message5",m4data);
        bundle.putString("message6",m5data);
        bundle.putString("message7",m6data);
        bundle.putString("message8",m7data);
        bundle.putString("message9",bd);



        secondFragment.setArguments(bundle);




        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer,secondFragment,null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }
}
