package com.example.th2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button buttonBai14 = findViewById(R.id.button_bai14);
        buttonBai14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TH2_Bai14.class);
                startActivity(intent);
            }
        });
        Button buttonBai15 = findViewById(R.id.button_bai15);
        buttonBai15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TH2_Bai15.class);
                startActivity(intent);
            }
        });
        Button buttonBai15_1 = findViewById(R.id.button_bai15_1);
        buttonBai15_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TH2_BaiTap15_Part2.class);
                startActivity(intent);
            }
        });
        Button buttonBai13 = findViewById(R.id.button_bai13);
        buttonBai13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TH2_Bai13.class);
                startActivity(intent);
            }
        });

        Button buttonBai12 = findViewById(R.id.button_bai12);
        buttonBai12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TH2_Bai12.class);
                startActivity(intent);
            }
        });
        Button buttonBai11 = findViewById(R.id.button_bai11);
        buttonBai11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TH2_Bai11.class);
                startActivity(intent);
            }
        });
        Button buttonBai10 = findViewById(R.id.button_bai10);
        buttonBai10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TH2_Bai10.class);
                startActivity(intent);
            }
        });
        Button buttonBai9 = findViewById(R.id.button_bai9);
        buttonBai9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TH2_Bai9.class);
                startActivity(intent);
            }
        });
        Button buttonBai7 = findViewById(R.id.button_bai7);
        buttonBai7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TH2_BaiTap7.class);
                startActivity(intent);
            }
        });
        Button buttonBai8 = findViewById(R.id.button_bai8);
        buttonBai8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TH_Bai8.class);
                startActivity(intent);
            }
        });
    }
}