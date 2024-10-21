package com.example.th2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TH2_BaiTap4 extends AppCompatActivity {
    EditText editTextTemperature;
    TextView textViewResult;
    Button btnConvertToCelsius, btnConvertToFahrenheit, btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_th2_bai_tap4);
        editTextTemperature = findViewById(R.id.editTextTemperature);
        textViewResult = findViewById(R.id.textViewResult);
        btnConvertToCelsius = findViewById(R.id.btnConvertToCelsius);
        btnConvertToFahrenheit = findViewById(R.id.btnConvertToFahrenheit);
        btnClear = findViewById(R.id.btnClear);

        // Sự kiện khi nhấn nút Convert to Celsius
        btnConvertToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = editTextTemperature.getText().toString();
                if (!temp.isEmpty()) {
                    double fahrenheit = Double.parseDouble(temp);
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    textViewResult.setText(String.format("%.2f°F is %.2f°C", fahrenheit, celsius));
                }
            }
        });

        // Sự kiện khi nhấn nút Convert to Fahrenheit
        btnConvertToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = editTextTemperature.getText().toString();
                if (!temp.isEmpty()) {
                    double celsius = Double.parseDouble(temp);
                    double fahrenheit = celsius * 9 / 5 + 32;
                    textViewResult.setText(String.format("%.2f°C is %.2f°F", celsius, fahrenheit));
                }
            }
        });

        // Sự kiện khi nhấn nút Clear
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextTemperature.setText("");
                textViewResult.setText("Result");
            }
        });

    }
}