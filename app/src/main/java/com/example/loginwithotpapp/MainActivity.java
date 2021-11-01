package com.example.loginwithotpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {
    EditText e;
    Button b;
    CountryCodePicker ccp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e = findViewById(R.id.editText1);
        b = findViewById(R.id.button1);
        ccp = findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(e);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e.getText().toString().isEmpty()){
                    e.setError("Please fill phone number");
                }
                else if(e.getText().toString().length()!=6){
                    e.setError("OTP not valid");
                }
                else{
                    Intent i = new Intent(MainActivity.this, Second.class);
                    i.putExtra("phone", e.getText());
                    startActivity(i);
                }
            }
        });
    }
}