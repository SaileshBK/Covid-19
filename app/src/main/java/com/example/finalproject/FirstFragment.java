
/* Name:FirstFragment.java
   Due Date:5/08/2020
   Description: This program is basically a  fragment to fragment communication to show the sharing of data between one fragment to another.
                In this program we collect the information from user using the interface of first fragment where we ask the user's FirstName, LastName,Gender,Date of Birth,Occupation,your age guess just to make the application a little more interactive.
                Here we used one RadioGroup(with three radio buttons),Datepicker( obtain a date using a CalendarView),progressbar,seekbar,spinner, simple date format etc.Later on these information we collected
                is sent to main activity because direct fragment to fragment communication is not valid so we need to go through main. In the second fragment we show the summary of input data with the age calculation
                of the user.Thank you.



*/
package com.example.finalproject;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private Button btncalcu,btnDateSelect;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;

    String bd,mtoday;
    DatePickerDialog.OnDateSetListener dateSetListener;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Spinner myspinner;
    private SeekBar myseekbar;
    private ProgressBar myprogress;
    private TextView textView,textoday,textDOB;
    int seekValue;


    OnDataSendListener myDataSendListener;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public interface OnDataSendListener
    {
       public void onDataSend(String s, String mdata, String mydata, String m2data, String m3data, String m4data, String m6data, String m7data, String bd);
    }

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_first, container, false);

        btncalcu = (Button)view.findViewById(R.id.calculate);
        editText1 = (EditText)view.findViewById(R.id.txtfirstname);
        editText2 = (EditText)view.findViewById(R.id.txtlastname);
        myspinner = view.findViewById(R.id.myspinner);
        myspinner = view.findViewById(R.id.myspinner);
        myspinner.setOnItemSelectedListener(this);

        //for date
        textoday = view.findViewById(R.id.current);
        textDOB = view.findViewById(R.id.DOB);
        btnDateSelect = view.findViewById(R.id.selectDOB);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        mtoday = simpleDateFormat.format(Calendar.getInstance().getTime());
        textoday.setText(mtoday);
        btnDateSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext(),dateSetListener,year,month,day);
                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                datePickerDialog.show();

            }
        });
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                bd = month +"/"+dayOfMonth+"/"+year;
                textDOB.setText(bd);

            }
        };





        myseekbar = view.findViewById(R.id.seekBar4);
        myprogress = view.findViewById(R.id.progressBar);
        textView = view.findViewById(R.id.textView3);
        myseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                myprogress.setProgress(progress);
                textView.setText("I am feeling "+progress+"%"+" Positive.");


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {




            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        radioGroup = view.findViewById(R.id.radiogroup);
        btncalcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bd==null){
                    Toast.makeText(getContext(),"please select your date of birth!",Toast.LENGTH_SHORT).show();
                }else {


                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
                    try {
                        Date newdate = simpleDateFormat1.parse(bd);
                        Date newdate1 = simpleDateFormat1.parse(mtoday);

                        long startDate = newdate.getTime();
                        long endDate = newdate1.getTime();
                        Period period = new Period(startDate, endDate, PeriodType.yearMonthDay());
                        int years = period.getYears();
                        int months = period.getMonths();
                        int days = period.getDays();
                        String m5data = String.valueOf(years);
                        String m6data = String.valueOf(months);
                        String m7data = String.valueOf(days);




                        int myradio = radioGroup.getCheckedRadioButtonId();
                        radioButton = view.findViewById(myradio);
                        String mdata = editText1.getText().toString();
                        String m1data = editText2.getText().toString();
                        String m2data = radioButton.getText().toString();
                        String m3data = myspinner.getSelectedItem().toString();
                        String m4data = textView.getText().toString();



                        myDataSendListener.onDataSend(mdata,m1data,m2data,m3data,m4data,m5data,m6data,m7data,bd);


                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }





            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        myDataSendListener = (OnDataSendListener) activity;
    }

    @Override
    public void onResume() {
        super.onResume();
        editText1.setText("");
    }
    public void checkButton(View v) {
        int myradio = radioGroup.getCheckedRadioButtonId();
        radioButton = radioButton.findViewById(myradio);


    }
}
