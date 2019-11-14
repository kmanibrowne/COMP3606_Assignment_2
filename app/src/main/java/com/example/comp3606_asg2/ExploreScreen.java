package com.example.comp3606_asg2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class ExploreScreen extends AppCompatActivity {
    int allBackgroundColor = Color.argb(255, 255, 255, 255);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        View parentLayout = findViewById(android.R.id.content);
        Intent intent = getIntent();

        //intent code

        if(intent.hasExtra("INTENTS_CALLBACK_RESULT_DATA")) {
            int intentCallBackResultData = intent.getIntExtra("INTENTS_CALLBACK_RESULT_DATA", 0);
            int intentCallBackDataValue0 = intent.getIntExtra("INTENTS_CALLBACK_DATA_0", 0);
            int intentCallBackDataValue1 = intent.getIntExtra("INTENTS_CALLBACK_DATA_1", 0);
            if(intentCallBackResultData != 0) {
                String tsResult = "Calculations from IntentsCallBack screen: (" + intentCallBackDataValue0 + " * " + intentCallBackDataValue1 + ") = " + intentCallBackResultData;
                Snackbar.make(parentLayout, tsResult, Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        }
    }

    public void onClickIntro(View view){
        Intent i = new Intent(ExploreScreen.this, AboutAndroid.class);
        startActivity(i);
    }

    public void onClickGUIComponents(View view){
        Intent i = new Intent(ExploreScreen.this, AndroidGUIComponents.class);
        startActivity(i);
    }

    public void onClickPaper1(View view){
        Intent i = new Intent(ExploreScreen.this, Paper1.class);
        startActivity(i);
    }

    public void onClickPaper2(View view){
        Intent i = new Intent(ExploreScreen.this, Paper2.class);
        startActivity(i);
    }

    public void onClickStartQuiz(View view){
        Intent i = new Intent(ExploreScreen.this, QuizScreen.class);
        startActivity(i);
    }

    public void onClickIntentCallBack(View view){
        Intent i = new Intent(ExploreScreen.this, IntentsCallBack.class);
        i.putExtra("BACKGROUND_COLOR", allBackgroundColor);
        i.putExtra("INTENTS_CALLBACK_DATA_0", new Random().nextInt(100));
        i.putExtra("INTENTS_CALLBACK_DATA_1", new Random().nextInt(100));
        startActivity(i);
    }


}
