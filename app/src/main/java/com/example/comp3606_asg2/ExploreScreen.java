package com.example.comp3606_asg2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class ExploreScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClickIntro(View view){
        Intent i = new Intent(ExploreScreen.this, AboutAndroid.class);
        startActivity(i);
    }

    public void onClickGUIComponents(View view){
        Intent i = new Intent(ExploreScreen.this, AndroidGUIComponents.class);
        startActivity(i);
    }

    public void onClickStartQuiz(View view){
        Intent i = new Intent(ExploreScreen.this, QuizScreen.class);
        startActivity(i);
    }
}
