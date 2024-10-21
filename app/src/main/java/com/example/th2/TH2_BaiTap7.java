package com.example.th2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TH2_BaiTap7 extends AppCompatActivity {
    private EditText edtusername, edtpassword;
    private CheckBox checkBox;
    private Button login, logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_th2_bai_tap7);
        edtusername = findViewById(R.id.username);
        edtpassword = findViewById(R.id.password);
        checkBox = findViewById(R.id.ckbox);
        login = findViewById(R.id.loginButton);
        logout = findViewById(R.id.exitButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtusername.getText().toString().equals("admin") && edtpassword.getText().toString().equals("22")) {
                    if (checkBox.isChecked()) {
                        Toast.makeText(TH2_BaiTap7.this, "chào mừng bạn đăng nhập hệ thống, bạn đã lưu thông tin", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(TH2_BaiTap7.this, "chào mừng bạn đăng nhập hệ thống, bạn đã khong lưu thông tin", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thoatChuongTrinh();
            }
        });
    }
        private void thoatChuongTrinh() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Xác nhận thoát")
                    .setMessage("Bạn có chắc chắn muốn thoát không?")
                    .setPositiveButton("Có", (dialog, which) -> finish())
                    .setNegativeButton("Không", null)
                    .show();
        }


}