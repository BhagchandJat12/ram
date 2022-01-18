package com.example.calendar;

import android.content.Context;
import android.os.Build;
import android.os.ConditionVariable;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.JsonReader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.time.LocalDate;
import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Eventcount {

    public   static ArrayList<Event> list=new ArrayList<>();
    static {
        list.add(new Event(1, LocalDate.parse("2022-01-04"), "Bhagchandjat-orientation"));
        list.add(new Event(2, LocalDate.parse("2022-01-03"), "Hemraj-orientation"));
        list.add(new Event(3, LocalDate.parse("2022-01-02"), "Bhagchandjat-Programming"));
        list.add(new Event(4, LocalDate.parse("2022-01-07"), "Bhagchandjat-Programmingjava"));
        list.add(new Event(5, LocalDate.parse("2022-01-07"), "Hemant -Movie"));
    }

    static int count(String date) {
        int count=0;
       for(Event e:list){
            if (date.equals(e.getDate().toString())) {
                count++;
            }

        }
        return  count;
    }
    static String getEvents(String date) {
        String s=" ";
       for (Event e:list){
            if (date.equals(e.getDate().toString())) {
                s=s+e.getEvent()+"\n \n";
            } else {
                continue;
            }

        }
        return  s;
    }


}
