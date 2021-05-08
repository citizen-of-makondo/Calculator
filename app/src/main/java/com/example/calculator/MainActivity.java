package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {

    private TextView calculationTextView;
    private TextView bufferTextView;

    private Double result = 0.0;
    private String lastOperation;

    private final static String calculationText = "calculationText";
    private final static String bufferText = "bufferText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(calculationText, calculationTextView.getText().toString());
        savedInstanceState.putString(bufferText, bufferTextView.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculationTextView.setText(savedInstanceState.getString(calculationText));
        bufferTextView.setText(savedInstanceState.getString(bufferText));
    }

    private void initViews() {
        findViewById(R.id.button_0);
        findViewById(R.id.button_1);
        findViewById(R.id.button_2);
        findViewById(R.id.button_3);
        findViewById(R.id.button_4);
        findViewById(R.id.button_5);
        findViewById(R.id.button_6);
        findViewById(R.id.button_7);
        findViewById(R.id.button_8);
        findViewById(R.id.button_9);
        findViewById(R.id.button_point);
        findViewById(R.id.button_plus);
        findViewById(R.id.button_minus);
        findViewById(R.id.button_multiplication);
        findViewById(R.id.button_divide);
        findViewById(R.id.button_result);
        findViewById(R.id.button_clear);
        calculationTextView = findViewById(R.id.calculation);
        bufferTextView = findViewById(R.id.bufferCalc);
    }

    public void clearAll(View view) {
        bufferTextView.setText("");
        calculationTextView.setText("");
    }

    public void action_button(View view) {
        switch (view.getId()) {
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
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + getComponentName().toString());
        }
    }

    public void onPlusClick(View view) {
        double count = Double.parseDouble(calculationTextView.getText().toString());
        result += count;
        lastOperation = "+";
        String strResult = calculationTextView.getText().toString();
        bufferTextView.setText(getResources().getString(R.string.result_template, strResult, " + "));
        calculationTextView.setText("");
    }

    public void onMinusClick(View view) {
        result = Double.parseDouble(calculationTextView.getText().toString());
        lastOperation = "-";
        String strResult = calculationTextView.getText().toString();
        bufferTextView.setText(getResources().getString(R.string.result_template, strResult, " - "));
        calculationTextView.setText("");
    }

    public void onMiltiClick(View view) {
        double count = Double.parseDouble(calculationTextView.getText().toString());
        result = 1.0;
        result = count;

        lastOperation = "*";
        String strResult = calculationTextView.getText().toString();
        bufferTextView.setText(getResources().getString(R.string.result_template, strResult, " * "));
        calculationTextView.setText("");
    }

    public void onDivideClick(View view) {
        double count = Double.parseDouble(calculationTextView.getText().toString());
        result = 1.0;
        result *= count;
        lastOperation = "/";
        String strResult = calculationTextView.getText().toString();
        bufferTextView.setText(getResources().getString(R.string.result_template, strResult, " / "));
        calculationTextView.setText("");
    }

    private void editText(String count) {
        String s = calculationTextView.getText().toString();
        s += count;
        calculationTextView.setText(s);
    }

    public void showResult(View view) {
        switch (lastOperation) {
            case "+":
                result += Double.parseDouble(calculationTextView.getText().toString());
                break;
            case "-":
                result -= Double.parseDouble(calculationTextView.getText().toString());
                break;
            case "*":
                result *= Double.parseDouble(calculationTextView.getText().toString());
                break;
            case "/":
                try {
                    result /= Double.parseDouble(calculationTextView.getText().toString());
                } catch (ArithmeticException e) {
                    calculationTextView.setText("На нуль делить нельзя");
                }
                break;
        }
        calculationTextView.setText(Double.toString(result));
        bufferTextView.setText("");
        result = 0.0;
    }

    public void onDeleteOneCount(View view) {
        String text = calculationTextView.getText().toString();
        if (text.equals("")) {
            calculationTextView.setText("");
        } else {
            calculationTextView.setText(text.substring(0, text.length() - 1));
        }
    }

    public void onChangePlusOrMinus(View view) {
        double count = Double.parseDouble(calculationTextView.getText().toString());
        count = count * (-1);
        calculationTextView.setText(String.valueOf(count));
    }

    public void onPercent(View view) {
        double count = Double.parseDouble(calculationTextView.getText().toString());
        count = count / 100;
        calculationTextView.setText(String.valueOf(count));
    }
}