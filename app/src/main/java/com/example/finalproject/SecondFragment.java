/* Name:SecondFragment.java
   Due Date:3/30/2020
   Description: This is the Second fragment  java file. Here  we just extract the data that is sent from MainActivity.java file and displayed in  textviews.



*/

package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9;
    ImageButton imageButton;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        textView1 = view.findViewById(R.id.msgdisplay);
        textView2 = view.findViewById(R.id.msgdisplay2);
        textView3 = view.findViewById(R.id.msgdisplay3);
        textView4 = view.findViewById(R.id.msgdisplay4);
        textView5 = view.findViewById(R.id.msgdisplay5);
        textView6 = view.findViewById(R.id.msgdisplay6);
        imageButton = view.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Second.class));
            }
        });







        Bundle bundle = getArguments();
        String message = bundle.getString("message");
        String message2 = bundle.getString("message2");
        String message3 = bundle.getString("message3");
        String message4 = bundle.getString("message4");
        String message5 = bundle.getString("message5");
        String message6 = bundle.getString("message6");
        String message7 = bundle.getString("message7");
        String message8 = bundle.getString("message8");
        String message9 = bundle.getString("message9");


        textView1.setText(message);
        textView2.setText(message2);
        textView3.setText(message3);
        textView4.setText(message4);
        textView5.setText(message5);
        textView6.setText(message9);


        return view;
    }
}
