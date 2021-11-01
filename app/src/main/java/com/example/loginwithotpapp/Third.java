package com.example.loginwithotpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

public class Third extends AppCompatActivity {
    EditText e;
    Button b;
    CountryCodePicker ccp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }
}