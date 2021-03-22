package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
    private TextView bufferTextView;

    private ArrayList<Double> counts = new ArrayList<>();
    private boolean isNextCount = false;
    private Double result = 0.0;
    private String lastOperation;

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
        bufferTextView = findViewById(R.id.bufferCalc);
    }

    public void clearAll(View view) {
        bufferTextView.setText("");
        calculationTextView.setText("");
    }

    public void action_button(View view) {
        switch (view.getId()) {
            case R.id.button_00:
                editText("00");
                break;
            case R.id.button_0:
                editText("0");
                break;
            case R.id.button_1:
                editText("1");
                break;
            case R.id.button_2:
                editText("2");
                break;
            case R.id.button_3:
                editText("3");
                break;
            case R.id.button_4:
                editText("4");
                break;
            case R.id.button_5:
                editText("5");
                break;
            case R.id.button_6:
                editText("6");
                break;
            case R.id.button_7:
                editText("7");
                break;
            case R.id.button_8:
                editText("8");
                break;
            case R.id.button_9:
                editText("9");
                break;
            case R.id.button_point:
                editText(".");
            default:
                throw new IllegalStateException("Unexpected value: " + getComponentName().toString());
        }
    }

    public void onPlusClick(View view) {
        Double count = Double.valueOf(calculationTextView.getText().toString());
        result += count;
        lastOperation = "+";
        bufferTextView.setText(calculationTextView.getText().toString() + " + ");
        calculationTextView.setText("");
    }

    public void onMinusClick(View view) {
        Double count = Double.valueOf(calculationTextView.getText().toString());
        result -= count;
        lastOperation = "-";
        bufferTextView.setText(calculationTextView.getText().toString() + " - ");
        calculationTextView.setText("");
    }

    /*public void onMiltiClick(View view) {
        Double count = Double.valueOf(calculationTextView.getText().toString());
        result *= count;
        lastOperation = "*";
        bufferTextView.setText(calculationTextView.getText().toString() + " * ");
        calculationTextView.setText("");
    }*/

    private void editText(String count) {
        String s = String.valueOf(calculationTextView.getText());
        s += count;
        calculationTextView.setText(s);
    }

    public void showResult(View view) {
        switch (lastOperation) {
            case "+":
                result += Double.valueOf(calculationTextView.getText().toString());
                break;
            case "-":
                result -= Double.valueOf(calculationTextView.getText().toString());
                break;
            case "*":
                result *=  Double.valueOf(calculationTextView.getText().toString());
                break;
            case "/":
                result /= Double.valueOf(calculationTextView.getText().toString());
                break;
        }
        calculationTextView.setText(Double.toString(result));
        isNextCount = false;
        counts.clear();

        bufferTextView.setText("");
        result = 0.0;
    }


}