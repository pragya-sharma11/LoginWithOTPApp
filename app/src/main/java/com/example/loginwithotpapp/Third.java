package com.example.loginwithotpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.hbb20.CountryCodePicker;

public class Third extends AppCompatActivity {
    Button b;
    FirebaseAuth f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        b = findViewById(R.id.button3);
        f = FirebaseAuth.getInstance();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f.signOut();
                Toast.makeText(Third.this, "Sign-out successful", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Third.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}