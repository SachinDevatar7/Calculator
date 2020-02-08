package com.example.sachindevatar.mylibrary;

import android.util.Log;

public class Logic {

//    String temp;
//
    private static final String TAG = "Logic";


    public Logic(){
        Log.d(TAG, "Logic: From My Library");
    }

    public double sineFunction(double number) {
        return Math.sin(number);
    }
    public double cosFunction(double number) {
        return Math.cos(number);
    }
    public double tanFunction(double number) {
        return Math.tan(number);
    }

}

