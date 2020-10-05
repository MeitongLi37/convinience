package com.example.convinience;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class weightConvert extends AppCompatActivity {
    EditText textBoxPound;
    EditText textBoxKg;
    EditText textBoxOunce;
    EditText textBoxGram;
    EditText textBoxGallon;
    EditText textBoxLiter;
    EditText textBoxOz;
    EditText textBoxMl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_convert);
        textBoxPound = (EditText) findViewById(R.id.editTextPound);
        textBoxKg = (EditText) findViewById(R.id.editTextKg);
        textBoxOunce = (EditText) findViewById(R.id.editTextOunce);
        textBoxGram = (EditText) findViewById(R.id.editTextGram);
        textBoxGallon = (EditText) findViewById(R.id.editTextGallon);
        textBoxLiter = (EditText) findViewById(R.id.editTextLiter);
        textBoxOz = (EditText) findViewById(R.id.editTextOz);
        textBoxMl = (EditText) findViewById(R.id.editTextMl);
        loadSavedPreferences();



        Button buttonConvertPound = (Button)findViewById(R.id.buttonConvertPound);
        buttonConvertPound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!textBoxPound.getText().toString().matches("") && textBoxPound.hasFocus()) {
                    double vPound = Double.valueOf(textBoxPound.getText().toString());
                    double vKg = vPound* 0.4536;
                    DecimalFormat formatVal = new DecimalFormat("##.##");
                    textBoxKg.setText(formatVal.format(vKg));
                }
                if (!textBoxKg.getText().toString().matches("") && textBoxKg.hasFocus()) {
                    double vKg = Double.valueOf(textBoxKg.getText().toString());
                    double vPound = vKg /0.4536;
                    DecimalFormat formatVal = new DecimalFormat("##.##");
                    textBoxPound.setText(formatVal.format(vPound));
                }
                ;
            }
        });
        Button buttonConvertOunce = (Button)findViewById(R.id.buttonConvertOunce);
        buttonConvertOunce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!textBoxOunce.getText().toString().matches("") && textBoxOunce.hasFocus()) {
                    double vOunce = Double.valueOf(textBoxOunce.getText().toString());
                    double vGram = vOunce* 28.35;
                    DecimalFormat formatVal = new DecimalFormat("##.##");
                    textBoxGram.setText(formatVal.format(vGram));
                }
                if (!textBoxGram.getText().toString().matches("") && textBoxGram.hasFocus()) {
                    double vGram = Double.valueOf(textBoxGram.getText().toString());
                    double vOunce = vGram /28.35;
                    DecimalFormat formatVal = new DecimalFormat("##.##");
                    textBoxOunce.setText(formatVal.format(vOunce));
                }
                ;
            }
        });
        Button buttonConvertGallon = (Button)findViewById(R.id.buttonConvertGallon);
        buttonConvertGallon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText textBoxGallon = (EditText) findViewById(R.id.editTextGallon);
                EditText textBoxLiter = (EditText) findViewById(R.id.editTextLiter);
                if (!textBoxGallon.getText().toString().matches("") && textBoxGallon.hasFocus()) {
                    double vGallon = Double.valueOf(textBoxGallon.getText().toString());
                    double vLiter = vGallon*3.785;
                    DecimalFormat formatVal = new DecimalFormat("##.##");
                    textBoxLiter.setText(formatVal.format(vLiter));
                }
                if (!textBoxLiter.getText().toString().matches("") && textBoxLiter.hasFocus()) {
                    double vLiter = Double.valueOf(textBoxLiter.getText().toString());
                    double vGallon = vLiter /3.785;
                    DecimalFormat formatVal = new DecimalFormat("##.##");
                    textBoxGallon.setText(formatVal.format(vGallon));
                }
                ;
            }
        });
        Button buttonConvertOz = (Button)findViewById(R.id.buttonConvertOz);
        buttonConvertOz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText textBoxOz = (EditText) findViewById(R.id.editTextOz);
                EditText textBoxMl = (EditText) findViewById(R.id.editTextMl);
                if (!textBoxOz.getText().toString().matches("") && textBoxOz.hasFocus()) {
                    double vOz = Double.valueOf(textBoxOz.getText().toString());
                    double vMl = vOz* 29.571;
                    DecimalFormat formatVal = new DecimalFormat("##.##");
                    textBoxMl.setText(formatVal.format(vMl));
                }
                if (!textBoxMl.getText().toString().matches("") && textBoxMl.hasFocus()) {
                    double vMl = Double.valueOf(textBoxMl.getText().toString());
                    double vOz = vMl /29.571;
                    DecimalFormat formatVal = new DecimalFormat("##.##");
                    textBoxOz.setText(formatVal.format(vOz));
                }
                ;
            }
        });
    }
    private void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }


    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        textBoxPound.setText(sharedPreferences.getString("string_et7",""));
        textBoxKg.setText(sharedPreferences.getString("string_et8",""));
        textBoxOunce.setText(sharedPreferences.getString("string_et9",""));
        textBoxGram.setText(sharedPreferences.getString("string_et10",""));
        textBoxGallon.setText(sharedPreferences.getString("string_et11",""));
        textBoxLiter.setText(sharedPreferences.getString("string_et12",""));
        textBoxOz.setText(sharedPreferences.getString("string_et13",""));
        textBoxMl.setText(sharedPreferences.getString("string_et14",""));


    }
    public void saveData(){
        savePreferences("string_et7", textBoxPound.getText().toString());
        savePreferences("string_et8", textBoxKg.getText().toString());
        savePreferences("string_et9", textBoxOunce.getText().toString());
        savePreferences("string_et10", textBoxGram.getText().toString());
        savePreferences("string_et11", textBoxGallon.getText().toString());
        savePreferences("string_et12", textBoxLiter.getText().toString());
        savePreferences("string_et13", textBoxOz.getText().toString());
        savePreferences("string_et14", textBoxMl.getText().toString());


    }
    public void onBackPressed(){
        saveData();
        super.onBackPressed();
    }
}