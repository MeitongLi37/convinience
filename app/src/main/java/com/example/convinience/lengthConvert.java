package com.example.convinience;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class lengthConvert extends AppCompatActivity {
    EditText textBoxMiles;
    EditText textBoxKm;
    EditText textBoxFoot;
    EditText textBoxMeter;
    EditText textBoxInch;
    EditText textBoxCm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_convert);
        textBoxMiles = (EditText) findViewById(R.id.editTextMile);
        textBoxKm = (EditText) findViewById(R.id.editTextKm);
        textBoxFoot = (EditText) findViewById(R.id.editTextFoot);
        textBoxMeter = (EditText) findViewById(R.id.editTextMeter);
        textBoxInch = (EditText) findViewById(R.id.editTextInch);
        textBoxCm = (EditText) findViewById(R.id.editTextCm);

        loadSavedPreferences();
        Button buttonConvertMile = (Button)findViewById(R.id.buttonConvertMile);
        buttonConvertMile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textBoxMiles.getText().toString().matches("") && textBoxMiles.hasFocus()) {
                    double vMiles = Double.valueOf(textBoxMiles.getText().toString());
                    double vKm = vMiles / 0.62137;
                    DecimalFormat formatVal = new DecimalFormat("##.##");
                    textBoxKm.setText(formatVal.format(vKm));
                }
                if (!textBoxKm.getText().toString().matches("") && textBoxKm.hasFocus()) {
                    double vKm = Double.valueOf(textBoxKm.getText().toString());
                    double vMiles = vKm * 0.62137;
                    DecimalFormat formatVal = new DecimalFormat("##.##");
                    textBoxMiles.setText(formatVal.format(vMiles));
                }
                ;
            }
        });
        Button buttonConvertFoot = (Button)findViewById(R.id.buttonConvertFoot);
        buttonConvertFoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!textBoxFoot.getText().toString().matches("") && textBoxFoot.hasFocus()) {
                    double vFoot = Double.valueOf(textBoxFoot.getText().toString());
                    double vMeter = vFoot*0.3048;
                    DecimalFormat formatVal = new DecimalFormat("##.##");
                    textBoxMeter.setText(formatVal.format(vMeter));
                }
                if (!textBoxMeter.getText().toString().matches("") && textBoxMeter.hasFocus()) {
                    double vMeter = Double.valueOf(textBoxMeter.getText().toString());
                    double vFoot = vMeter /0.3048;
                    DecimalFormat formatVal = new DecimalFormat("##.##");
                    textBoxFoot.setText(formatVal.format(vFoot));
                }
                ;
            }
        });
        Button buttonConvertInch = (Button)findViewById(R.id.buttonConvertInch);
        buttonConvertInch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!textBoxInch.getText().toString().matches("") && textBoxInch.hasFocus()) {
                    double vInch = Double.valueOf(textBoxInch.getText().toString());
                    double vCm = vInch*2.54;
                    DecimalFormat formatVal = new DecimalFormat("##.##");
                    textBoxCm.setText(formatVal.format(vCm));
                }
                if (!textBoxCm.getText().toString().matches("") && textBoxCm.hasFocus()) {
                    double vCm = Double.valueOf(textBoxCm.getText().toString());
                    double vInch = vCm /2.54;
                    DecimalFormat formatVal = new DecimalFormat("##.##");
                    textBoxInch.setText(formatVal.format(vInch));
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

        textBoxMiles.setText(sharedPreferences.getString("string_et1",""));
        textBoxKm.setText(sharedPreferences.getString("string_et2",""));
        textBoxFoot.setText(sharedPreferences.getString("string_et3",""));
        textBoxMeter.setText(sharedPreferences.getString("string_et4",""));
        textBoxInch.setText(sharedPreferences.getString("string_et5",""));
        textBoxCm.setText(sharedPreferences.getString("string_et6",""));


    }





    public void saveData(){
        savePreferences("string_et1", textBoxMiles.getText().toString());
        savePreferences("string_et2", textBoxKm.getText().toString());
        savePreferences("string_et3", textBoxFoot.getText().toString());
        savePreferences("string_et4", textBoxMeter.getText().toString());
        savePreferences("string_et5", textBoxInch.getText().toString());
        savePreferences("string_et6", textBoxCm.getText().toString());

    }

    public void onBackPressed(){
        saveData();
        super.onBackPressed();
    }



}







