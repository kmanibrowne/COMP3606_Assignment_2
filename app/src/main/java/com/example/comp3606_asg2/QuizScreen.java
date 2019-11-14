package com.example.comp3606_asg2;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Locale;

public class QuizScreen extends AppCompatActivity {

    Button finishAttempt;
    public static String fileName = "testing.txt";

    private static final long START_TIME_IN_MILLIS = 300000;

    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        finishAttempt = (Button)findViewById(R.id.submit);
        mTextViewCountDown = findViewById(R.id.text_view_countdown);

        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);

        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });


        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        updateCountDownText();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if( id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText("pause");
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }

    public void SaveFile(String file, String text){
        try{
            FileOutputStream fout = openFileOutput(file, Context.MODE_PRIVATE);
            fout.write(text.getBytes());
            Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error met while saving file.", Toast.LENGTH_SHORT).show();
        }
    }


    public  String ReadFromFile(String file){
        String data = "";
        try{
            FileInputStream fin = openFileInput(file);
            int size = fin.available();
            byte[] buffer = new byte[size];
            fin.read(buffer);
            fin.close();
            data = new String(buffer);
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error trying to read data from file.", Toast.LENGTH_SHORT).show();
        }
        return data;
    }

    public void calculateScore(){
        EditText q1, q2, q3, q4, q5, mEdit;
        int score1=0, score2=0, score3=0, score4=0, score5=0;
        String answer1, answer2, answer3, answer4, answer5, temp1, temp2, temp3, temp4, temp5;

        q1 = (EditText)findViewById(R.id.editText_q1);
        temp1 = q1.getText().toString();
        temp1 = temp1.toLowerCase();
        answer1 = temp1;

        if(answer1.equals("edittext")){
            score1 = 1;
        }

        q2 = (EditText)findViewById(R.id.editText_q2);
        temp2 = q2.getText().toString();
        temp2 = temp2.toLowerCase();
        answer2 = temp2;

        if(answer2.equals("button")){
            score2 = 1;
        }

        q3 = (EditText)findViewById(R.id.editText_q3);
        temp3 = q3.getText().toString();
        temp3 = temp3.toLowerCase();
        answer3 = temp3;

        if(answer3.equals("toast")){
            score3 = 1;
        }

        q4 = (EditText)findViewById(R.id.editText_q4);
        temp4 = q4.getText().toString();
        temp4 = temp4.toLowerCase();
        answer4 = temp4;

        if(answer4.equals("spinner")){
            score4 = 1;
        }

        q5 = (EditText)findViewById(R.id.editText_q5);
        temp5 = q5.getText().toString();
        temp5 = temp5.toLowerCase();
        answer5 = temp5;

        if(answer5.equals("datepicker")){
            score5 = 1;
        }


        int totalScore = score1+score2+score3+score4+score5;
        String f = String.valueOf(totalScore);
        mEdit = (EditText) findViewById(R.id.editText_score);

        mEdit.setText(f + "");
        mEdit = (EditText) findViewById(R.id.editText_prev_score);
        mEdit.setText(ReadFromFile(fileName));
        SaveFile(fileName,f);
    }

    public void findScore(View view){
        if(view == finishAttempt){
            Toast.makeText(this, "Calculating Score...", Toast.LENGTH_SHORT).show();
            ReadFromFile(fileName);
            calculateScore();
        }

    }




}
