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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import java.util.regex.Pattern;

public class signup extends AppCompatActivity implements View.OnClickListener{

    EditText editTexte,editTextp;
    ProgressBar progressBar2;
    private FirebaseAuth Auth;
    private Button buttonjoin;
    private TextView tlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Auth = FirebaseAuth.getInstance();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        editTexte =(EditText)findViewById(R.id.editTexte);
        editTextp =(EditText)findViewById(R.id.editTextp);
        progressBar2 =(ProgressBar)findViewById(R.id.progressBar2);
        buttonjoin = (Button) findViewById(R.id.buttonjoin);
        buttonjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void registerUser() {
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

        progressBar2.setVisibility(View.VISIBLE);


        Auth.createUserWithEmailAndPassword(email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar2.setVisibility(View.INVISIBLE);
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "User Registered", Toast.LENGTH_SHORT);
                }
                else{

                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT);
                    }

                }

            }
        });



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.buttonjoin:
                registerUser();
                break;



        }
    }
}

