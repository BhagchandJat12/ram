package com.example.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{
    CalendarView calendarView;
    TextView Main;
    Context context ;
    Button button;
    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context =getApplicationContext();
        calendarView= findViewById(R.id.calendarView);
        Main=findViewById(R.id.Main);
        button=findViewById(R.id.button);
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            String Date;
            if(month<=8 && dayOfMonth<=9){
                Date=year+"-0"+(month+1)+"-0"+dayOfMonth;
            }else if(month<=8 && dayOfMonth>9){
                Date=year+"-0"+(month+1)+"-"+dayOfMonth;
            }else if(month>8 && dayOfMonth<=9){
                Date=year+"-"+(month+1)+"-0"+dayOfMonth;
            }else {
                Date=year+"-"+(month+1)+"-"+dayOfMonth;
            }

            Main.setText(Date+"("+Eventcount.count(Date)+")");


            Main.setOnClickListener(v -> Toast.makeText(context,  Eventcount.getEvents(Date), Toast.LENGTH_SHORT).show());
        });
   button.setOnClickListener(v -> {
       Intent i=new Intent(getApplicationContext(),AddEvent.class);
       startActivity(i);
   });






    }
}