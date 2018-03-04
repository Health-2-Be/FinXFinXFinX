package com.example.nicholas.pound_slasher;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class statusreport extends AppCompatActivity {

    private Button buttonbmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusreport);
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

        buttonbmi = (Button) findViewById(R.id.buttonbmi);
        buttonbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBMICalc();
            }
        });

    }

    public void openBMICalc(){
        Intent intent = new Intent(this,bmicalc.class);
        startActivity(intent);
    }
}
