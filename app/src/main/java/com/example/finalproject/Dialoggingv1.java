/*Description:This program allows used to create  a valid user with username and password is is
later saved stored and used to login the application. After that it prompts a quiz app in which we can select the option
of radio buttons in which if you select the right answer that is stored in database  the text turns into green , in this process the high score and number of
question is tracked along with the different question. at the end the high score is displayed . and stored even when the app is closed.For this activity there is a animation screen of top and bottom animation in which top animation includes the image view and bottom
animation includes two text view with duration set to 3 seconds.The delay time is 4.5 seconds.I changed the default main activity shown to this custom activity, therefore this screen will be shown at
the beginning of this app.


Due Date:4/5/2020

*/

package com.example.finalproject;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialoggingv1 extends AppCompatDialogFragment {
    private DialogListener myListener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Attention!")
                .setMessage("You are going to Start Coronavirus (COVID-19) Self-Checker. ")
                .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                })
        .setPositiveButton("start", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                myListener.onYesClicked();

            }
        });
        return builder.create();
    }
    public interface DialogListener {
        void onYesClicked();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            myListener = (DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"you must implement DialogListener");
        }
    }
}
