package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    ArrayList<Integer> answer = new ArrayList<Integer>();

    public void ready(View view){
        ready.setVisibility(View.INVISIBLE);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editSum = findViewById(R.id.editSum);
        Button  button1 = findViewById(R.id.button1);
        Button  button2 = findViewById(R.id.button2);
        Button  button3 = findViewById(R.id.button3);
        Button  button4 = findViewById(R.id.button4);

        ready = findViewById(R.id.goButton);
        Random rand = new Random();      /**takes random values**/
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        editSum.setText(Integer.toString(a) +"+" + Integer.toString(b));
        int position = rand.nextInt(3);
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
}