package com.example.braintrainer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button ready;
    EditText editSum;
    TextView editOutcome;
    TextView editScore;
    TextView timer;
    int position;
    int ans;
    int ques;
    Button  button1;
    Button  button2;
    Button  button3;
    Button  button4;
    Button playAgain;
    ArrayList<Integer> answer = new ArrayList<Integer>();

    public void ready(View view){
        ready.setVisibility(View.INVISIBLE);
    }

    public void newQuestion(){
        Random rand = new Random();      /**takes random values**/
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        editSum.setText(Integer.toString(a) +"+" + Integer.toString(b));
        position = rand.nextInt(3);
        answer.clear();
        for(int i=0;i<4;i++)
        {
            if( position == i)
            {
                answer.add(a+b);
            }
            else
            {
                int wrong = rand.nextInt(41);
                while(wrong  == (a+b)){
                    wrong=rand.nextInt(41);
                }
                answer.add(wrong);
            }
        }
        button1.setText(Integer.toString(answer.get(0)));
        button2.setText(Integer.toString(answer.get(1)));
        button3.setText(Integer.toString(answer.get(2)));
        button4.setText(Integer.toString(answer.get(3)));

    }
    public void clicked(View view){
        if(Integer.toString(position+1).equals(view.getTag().toString()))
        {
            ans++;
            editOutcome.setText("correct!!!");
        }

        else
        {
            editOutcome.setText("wrong(:");
            Log.i("tag name","blodody fool");
        }
            ques++;
            editScore.setText(Integer.toString(ans) + "/" + Integer.toString(ques));
            newQuestion();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editSum = findViewById(R.id.editSum);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        editOutcome = findViewById(R.id.outcome);
        editScore = findViewById(R.id.editScore);
        ready = findViewById(R.id.goButton);
        timer = findViewById(R.id.timer);
        playAgain= findViewById(R.id.playAgain);
        newQuestion();
        CountDownTimer countDownTimer = new CountDownTimer(5100,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(millisUntilFinished/1000) + "s");
            }

            @Override
            public void onFinish() {
                    editOutcome.setText("DONE!!!!");
            }
        }.start();
    }
}