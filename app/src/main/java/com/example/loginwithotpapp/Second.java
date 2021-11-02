package com.example.loginwithotpapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Second extends AppCompatActivity {
    Button b;
    EditText e;
    FirebaseAuth f;
    String mobile, otp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mobile = getIntent().getStringExtra("phone").toString();
        b = findViewById(R.id.button2);
        e = findViewById(R.id.editText2);
        f = FirebaseAuth.getInstance();

        genOTP();
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
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otp, e.getText().toString());
                    signinWithPhoneAuthCredential(credential);
                }
            }
        });

    }
    public void genOTP(){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                mobile,
                60,
                TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        otp = s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        signinWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(Second.this, "Verification failed", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
    public  void signinWithPhoneAuthCredential(PhoneAuthCredential credential){
        f.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Second.this, "Verified", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Second.this, Third.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(Second.this, "Signin failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}