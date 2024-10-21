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

public class TH_Bai8 extends AppCompatActivity {
    private EditText editTextYear;
    private Button buttonConvert;
    private TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_th_bai8);

        editTextYear = findViewById(R.id.editTextYear);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        // Set sự kiện click cho nút chuyển đổi
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yearStr = editTextYear.getText().toString();
                if (!yearStr.isEmpty()) {
                    int year = Integer.parseInt(yearStr);
                    String lunarYear = convertToLunar(year);
                    textViewResult.setText("Năm âm lịch: " + lunarYear);
                } else {
                    textViewResult.setText("Vui lòng nhập năm Dương lịch.");
                }
            }
        });
    }

    // Hàm chuyển đổi năm Dương lịch sang Âm lịch
    private String convertToLunar(int year) {
        String[] lunarZodiac = {"Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi"};
        String[] heavenlyStems = {"Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ", "Canh", "Tân", "Nhâm", "Quý"};

        int zodiacIndex = (year - 4) % 12; // 12 con giáp
        int heavenlyStemIndex = (year - 4) % 10; // 10 thiên can

        return heavenlyStems[heavenlyStemIndex] + " " + lunarZodiac[zodiacIndex];
    }

}