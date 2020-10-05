package com.example.convinience;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class tempConvert extends AppCompatActivity {
    EditText textBoxFahrenheit;
    EditText textBoxCelsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_convert);
        textBoxFahrenheit = (EditText) findViewById(R.id.editTextFahrenheit);
        textBoxCelsius = (EditText) findViewById(R.id.editTextCelsius);
        loadSavedPreferences();
        Button buttonConvertFahrenheit = (Button)findViewById(R.id.buttonConvertFahrenheit);
        buttonConvertFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!textBoxFahrenheit.getText().toString().matches("") && textBoxFahrenheit.hasFocus()) {
                    double vFahrenheit = Double.valueOf(textBoxFahrenheit.getText().toString());
                    double vCelsius = (vFahrenheit-32)* 0.5556;
                    DecimalFormat formatVal = new DecimalFormat("##.##");
                    textBoxCelsius.setText(formatVal.format(vCelsius));
                }
                if (!textBoxCelsius.getText().toString().matches("") && textBoxCelsius.hasFocus()) {
                    double vCelsius = Double.valueOf(textBoxCelsius.getText().toString());
                    double vFahrenheit = vCelsius /0.5556+32;
                    DecimalFormat formatVal = new DecimalFormat("##.##");
                    textBoxFahrenheit.setText(formatVal.format(vFahrenheit));
                }
                ;
            }
        });
    }
    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        textBoxFahrenheit.setText(sharedPreferences.getString("string_et15",""));
        textBoxCelsius.setText(sharedPreferences.getString("string_et16",""));
    }

    private void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void saveData(){
        savePreferences("string_et15", textBoxFahrenheit.getText().toString());
        savePreferences("string_et16", textBoxCelsius.getText().toString());


    }

    public void onBackPressed(){
        saveData();
        super.onBackPressed();
    }
}