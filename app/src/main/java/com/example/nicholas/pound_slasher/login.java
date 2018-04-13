package com.example.nicholas.pound_slasher;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class login extends AppCompatActivity implements View.OnClickListener{
    FirebaseAuth mAuth;
    private Button buttonsignup2;
    private Button btnlogin;
    ProgressBar progressBar3;
    EditText editTexte,editTextp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.btnlogin).setOnClickListener(this);
        progressBar3 =(ProgressBar)findViewById(R.id.progressBar3);
        editTexte =(EditText)findViewById(R.id.editTexte);
        editTextp =(EditText)findViewById(R.id.editTextp);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        buttonsignup2 = (Button) findViewById(R.id.buttonsignup2);
        buttonsignup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUp();
            }
        });
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAfterLogin();
            }
        });


    }
    public void openSignUp(){
        Intent intent = new Intent(this,signup.class);
        startActivity(intent);
    }
    public void openAfterLogin(){
        Intent intent = new Intent(this,afterlogin.class);
        startActivity(intent);
    }

    private void login(){
        String email = editTexte.getText().toString().trim();
        String Password = editTextp.getText().toString().trim();

        if (email.isEmpty()) {
            editTexte.setError("Email is required");
            editTexte.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTexte.setError("Email is not Valid");
            editTexte.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            editTextp.setError("Password is required");
            editTextp.requestFocus();
            return;
        }
        if (Password.length() < 6) {
            editTextp.setError("Please fill in a vaild password");
            editTextp.requestFocus();
            return;
        }

        progressBar3.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    openAfterLogin();
                }
                else{
                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT);
                }
            }
        });

    }

    @Override
    public void onClick(View view) {

       switch (view.getId()){
           case R.id.btnlogin:

               login();

               break;

       }

    }
}
