package com.example.comp3606_asg2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

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

    public void onClickIntentCallBack(View view){
        Intent i = new Intent(ExploreScreen.this, IntentsCallBack.class);
        startActivityForResult(i,1);
        startActivity(i);
    }

    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("result");
                Toast.makeText(ExploreScreen.this,"DATA From CallBack Screen = "+result, Toast.LENGTH_LONG).show();
            }
            if(resultCode == Activity.RESULT_CANCELED){
                Toast.makeText(this, "Nothing Returned", Toast.LENGTH_LONG).show();
            }
        }
    }
}
