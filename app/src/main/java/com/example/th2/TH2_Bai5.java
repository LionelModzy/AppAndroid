package com.example.th2;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class TH2_Bai5 extends AppCompatActivity {
    private TextView reSulttextview;
    private String currentInput = "";
    private String operator = "";
    private String saveString = "";
    private double saveResult = 0;
    private double firstNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th2_bai5);
        reSulttextview = findViewById(R.id.resultTextView);

    }
    public void onDeleteClick(View view){
        reSulttextview.setText("0");
        currentInput ="";
        operator ="";
        firstNumber =0 ;
    }
    public void onNumberClick(View view){
        if (saveString == ""){
            Button button = (Button) view;
            currentInput = currentInput + button.getText().toString();
            reSulttextview.setText(currentInput);
        }
        else {
            Button button = (Button) view;
            currentInput = currentInput + button.getText().toString();
            reSulttextview.setText(saveString+currentInput);
            saveString = "";
        }


    }
    public void onOperatorClick(View view){
        Button button = (Button) view;
        operator = button.getText().toString();
        firstNumber = Double.parseDouble(currentInput);
        reSulttextview.setText(currentInput+button.getText().toString());
        saveString = currentInput+button.getText().toString();
        currentInput = "";
    }
    public void onEqualClick(View view){
        Button button = (Button) view;
        double secondNumber = Double.parseDouble(currentInput);
        double result = 0;
        switch (operator){
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "x":
                result = firstNumber * secondNumber;
                break;
            case "÷":
                result = firstNumber / secondNumber;
                break;

        }
        reSulttextview.setText(String.valueOf(result));
        currentInput = String.valueOf(result);;
        saveResult = Double.parseDouble(currentInput);
    }
}