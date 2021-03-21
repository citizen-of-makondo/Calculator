package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button_00;
    private Button button_0;
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_9;
    private Button button_plus;
    private Button button_minus;
    private Button button_multiplication;
    private Button button_divide;
    private Button button_result;
    private Button button_clear;

    private TextView calculationTextView;
    private TextView resultTextView;

    private ArrayList<Integer> counts;
    private boolean isNextCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        button_00 = findViewById(R.id.button_00);
        button_0 = findViewById(R.id.button_0);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);
        button_plus = findViewById(R.id.button_plus);
        button_minus = findViewById(R.id.button_minus);
        button_multiplication = findViewById(R.id.button_multiplication);
        button_divide = findViewById(R.id.button_divide);
        button_result = findViewById(R.id.button_result);
        button_clear = findViewById(R.id.button_clear);

        calculationTextView = findViewById(R.id.calculation);
        resultTextView = findViewById(R.id.result);
    }
}