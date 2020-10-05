package com.example.convinience;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonLength = (Button)findViewById(R.id.button_Length);
        Button buttonWeight = (Button)findViewById(R.id.button_Weight);
        Button buttonTime = (Button)findViewById(R.id.button_Time);
        Button buttonTemp = (Button)findViewById(R.id.button_Temperature);
        Button buttonSize = (Button)findViewById(R.id.button_size);
    }
    public void goToLength(View v){
        Intent goToLength = new Intent();
        goToLength.setClass(this,lengthConvert.class);
        startActivity(goToLength);

    }
    public void goToWeight(View v){
        Intent goToWeight = new Intent();
        goToWeight.setClass(this,weightConvert.class);
        startActivity(goToWeight);

    }
    public void goToTime(View v){
        Intent goToTime = new Intent();
        goToTime.setClass(this,timeConvert.class);
        startActivity(goToTime);


    }
    public void goToSize(View v) {
        Intent goToSize = new Intent();
        goToSize.setClass(this, sizeConvert.class);
        startActivity(goToSize);
    }
    public void goToTemp(View v){
        Intent goToTemp = new Intent();
        goToTemp.setClass(this,tempConvert.class);
        startActivity(goToTemp);
    }

    public void onDestroy() {
        super.onDestroy();
        clear_pref();

    }
    public void clear_pref() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

}