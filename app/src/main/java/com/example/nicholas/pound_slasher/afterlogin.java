package com.example.nicholas.pound_slasher;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class afterlogin extends AppCompatActivity {

    ConstraintLayout myLayoutafterlogin;
    AnimationDrawable animationDrawable;

    private Button buttonm;
    private Button buttonex;
    private Button buttond;
    private Button buttonsr;
    private Button buttonset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afterlogin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        myLayoutafterlogin = (ConstraintLayout) findViewById(R.id.myLayoutafterlogin);

        animationDrawable = (AnimationDrawable) myLayoutafterlogin.getBackground();
        animationDrawable.setEnterFadeDuration(4000);
        animationDrawable.setExitFadeDuration(4000);
        //animationDrawable.start();
        //remove the ( // ) from animationDrawable.start() when login page is functional


        buttonm = (Button) findViewById(R.id.buttonm);
        buttonm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMachine();
            }
        });
        buttonex = (Button) findViewById(R.id.buttonex);
        buttonex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openExercise();
            }
        });
        buttond = (Button) findViewById(R.id.buttond);
        buttond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDietary();
            }
        });
        buttonsr = (Button) findViewById(R.id.buttonsr);
        buttonsr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStatusReport();
            }
        });
        buttonset = (Button) findViewById(R.id.buttonset);
        buttonset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettings();
            }
        });
    }
    public void openMachine(){
        Intent intent = new Intent(this,machine.class);
        startActivity(intent);
    }
    public void openExercise(){
        Intent intent = new Intent(this,exercise.class);
        startActivity(intent);
    }
    public void openDietary(){
        Intent intent = new Intent(this,dietary.class);
        startActivity(intent);
    }
    public void openStatusReport(){
        Intent intent = new Intent(this,statusreport.class);
        startActivity(intent);
    }
    public void openSettings(){
        Intent intent = new Intent(this,settingpage.class);
        startActivity(intent);
    }


}
