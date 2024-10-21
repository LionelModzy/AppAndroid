package com.example.th2;

import static com.example.th2.R.*;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TH2_BaiTap3 extends AppCompatActivity {
    private EditText soA, soB, edtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_th2_bai_tap3);
        soA = findViewById(R.id.editTextNumber);
        soB = findViewById(R.id.editTextNumber2);
        edtResult = findViewById(R.id.edtResult);
        // Inline anonymous listener cho nút Hiệu 2 số
        Button btnHieu = findViewById(R.id.btnHieu);
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(soA.getText().toString());
                int b = Integer.parseInt(soB.getText().toString());
                edtResult.setText("Hiệu: " + (a - b));
            }
        });

        // Activity as listener cho nút Tích 2 số
        Button btnTich = findViewById(R.id.btnTich);
        btnTich.setOnClickListener(this::tichHaiSo);

        // Listener in variable cho nút Thương 2 số
        Button btnThuong = findViewById(R.id.btnThuong);
        View.OnClickListener listenerThuong = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(soA.getText().toString());
                int b = Integer.parseInt(soB.getText().toString());
                if (b != 0) {
                    edtResult.setText("Thương: " + (a / b));
                } else {
                    edtResult.setText("Không thể chia cho 0");
                }
            }
        };
        btnThuong.setOnClickListener(listenerThuong);

        // Explicit listener class cho nút Ước số chung lớn nhất
        Button btnUoc = findViewById(R.id.btnUocChungLonNhat);
        btnUoc.setOnClickListener(new UocChungLonNhatListener());

        // View subclassing cho nút Thoát chương trình
        Button btnThoat = findViewById(R.id.btnThoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Thoát chương trình
            }
        });
    }

    // OnClick in XML cho nút Tổng 2 số
    public void tongHaiSo(View v) {
        int a = Integer.parseInt(soA.getText().toString());
        int b = Integer.parseInt(soB.getText().toString());
        edtResult.setText("Tổng: " + (a + b));
    }

    // Activity as listener method cho nút Tích 2 số
    public void tichHaiSo(View v) {
        int a = Integer.parseInt(soA.getText().toString());
        int b = Integer.parseInt(soB.getText().toString());
        edtResult.setText("Tích: " + (a * b));
    }

    // Explicit listener class cho Ước số chung lớn nhất
    class UocChungLonNhatListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int a = Integer.parseInt(soA.getText().toString());
            int b = Integer.parseInt(soB.getText().toString());
            edtResult.setText("ƯCLN: " + ucln(a, b));
        }

        private int ucln(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    }


}
