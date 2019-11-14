package com.example.comp3606_asg2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class IntentsCallBack extends AppCompatActivity {
    private Button callBackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents_call_back);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        callBackBtn = findViewById(R.id.button_callBack);
        int num = 620;
        String returnVal = "CallBack returned value "+Integer.toString(num);
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",returnVal);
        setResult(Activity.RESULT_OK,returnIntent);
        callBackBtn.setOnClickListener(new Button_Clicker());
    }

    class Button_Clicker implements  Button.OnClickListener{
        @Override
        public void onClick(View v){
            callBackBtn.setText("Quitting.");
            finish();
        }
    }

}
