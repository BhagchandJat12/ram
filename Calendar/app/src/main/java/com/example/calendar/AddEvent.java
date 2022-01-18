package com.example.calendar;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;


import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import java.time.LocalDate;

import java.util.Calendar;
import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.O)
public class AddEvent extends AppCompatActivity {
    TextView Id;
    TextView Event;
    TextView Date;
    EditText id,event,date;
    Context context;
    Button b;
   final Calendar calendar=Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addevent);
        context = getApplicationContext();
        Id= findViewById(R.id.Id);
        Event= findViewById(R.id.event);
        Date= findViewById(R.id.date);
        id= findViewById(R.id.Idin);
        event= findViewById(R.id.Eventin);
        date=findViewById(R.id.Datein);
        b=findViewById(R.id.button2);
        DatePickerDialog.OnDateSetListener d= (view, year, month, dayOfMonth) -> {
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,month);
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            updateLabel();
        };
        date.setOnClickListener(v -> new DatePickerDialog(AddEvent.this,d,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show());
      b.setOnClickListener(v -> {
          int i= Integer.parseInt(id.getText().toString());
          LocalDate da=LocalDate.parse(date.getText().toString());
          String s= event.getText().toString();
          Eventcount.list.add(new Event(i,da,s));
          Intent a=new Intent(getApplicationContext(),MainActivity.class);
          startActivity(a);
      });
    }

    private void updateLabel() {
        String myformat="yyyy/MM/dd";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myformat, Locale.US);
        date.setText(dateFormat.format(calendar.getTime()));
    }


}