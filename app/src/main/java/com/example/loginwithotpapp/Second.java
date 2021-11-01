package com.example.loginwithotpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class Second extends AppCompatActivity {
    Button b;
    EditText e;
    FirebaseAuth f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        b = findViewById(R.id.button2);
        e = findViewById(R.id.editText2);
        f = FirebaseAuth.getInstance();

    }
}