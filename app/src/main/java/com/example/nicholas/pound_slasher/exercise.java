package com.example.nicholas.pound_slasher;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class exercise extends AppCompatActivity {
    private Button buttonstretches;
    private Button buttonspeed;
    private Button buttonstrength;
    private Button buttonflexibility;
    private Button buttonendurance;
    private Button buttonstamina;
    private Button buttoncoree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
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
        buttonstretches = (Button) findViewById(R.id.buttonstretches);
        buttonstretches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openExercisesStretches();
            }
        });
        buttonspeed = (Button) findViewById(R.id.buttonspeed);
        buttonspeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openExercisesSpeed();
            }
        });
        buttonstrength = (Button) findViewById(R.id.buttonstrength);
        buttonstrength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openExercisesStrength();
            }
        });
        buttonflexibility = (Button) findViewById(R.id.buttonmflexibility);
        buttonflexibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openExercisesFlexibility();
            }
        });
        buttonendurance = (Button) findViewById(R.id.buttonendurance);
        buttonendurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openExercisesEndurance();
            }
        });
        buttonstamina = (Button) findViewById(R.id.buttonstamina);
        buttonstamina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openExercisesStamina();
            }
        });
        buttoncoree = (Button) findViewById(R.id.buttoncoree);
        buttoncoree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openExercisesCore();
            }
        });

    }
    public void openExercisesStretches(){
        Intent intent = new Intent(this,exercisesstretches.class);
        startActivity(intent);
    }
    public void openExercisesSpeed(){
        Intent intent = new Intent(this,exercisesspeed.class);
        startActivity(intent);
    }
    public void openExercisesStrength(){
        Intent intent = new Intent(this,exercisesstrength.class);
        startActivity(intent);
    }
    public void openExercisesFlexibility(){
        Intent intent = new Intent(this,exercisesflexibility.class);
        startActivity(intent);
    }
    public void openExercisesEndurance(){
        Intent intent = new Intent(this,exercisesendurance.class);
        startActivity(intent);
    }
    public void openExercisesStamina(){
        Intent intent = new Intent(this,exercisesstamina.class);
        startActivity(intent);
    }
    public void openExercisesCore(){
        Intent intent = new Intent(this,exercisescore.class);
        startActivity(intent);
    }

}
