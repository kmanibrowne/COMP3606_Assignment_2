package com.example.comp3606_asg2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.View;
import android.widget.Button;

public class IntentsCallBack extends AppCompatActivity {
    private Button callBackBtn;

    int allBackgroundColor = Color.argb(255, 255, 255, 255);
    int exploreScreenValue0 = 0;
    int exploreScreenValue1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents_call_back);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if(intent.hasExtra("BACKGROUND_COLOR")) {
            ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.callBack_screen);
            allBackgroundColor = intent.getIntExtra("BACKGROUND_COLOR", 0);
            bgElement.setBackgroundColor(allBackgroundColor);
        }
        exploreScreenValue0 = getIntent().getIntExtra("INTENTS_CALLBACK_DATA_0", 0);
        exploreScreenValue1 = getIntent().getIntExtra("INTENTS_CALLBACK_DATA_1", 0);
    }


    public void intentCallBack(View view){
        Intent i = new Intent(IntentsCallBack.this, ExploreScreen.class);
        i.putExtra("BACKGROUND_COLOR", allBackgroundColor);
        i.putExtra("INTENTS_CALLBACK_DATA_0", exploreScreenValue0);
        i.putExtra("INTENTS_CALLBACK_DATA_1", exploreScreenValue1);
        i.putExtra("INTENTS_CALLBACK_RESULT_DATA", exploreScreenValue0 * exploreScreenValue1);
        startActivity(i);
    }

}
