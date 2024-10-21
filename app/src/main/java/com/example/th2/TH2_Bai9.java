package com.example.th2;

import android.os.Bundle;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TH2_Bai9 extends AppCompatActivity {
    private EditText etHoTen, etCMND, etThongTinBoSung;
    private RadioGroup rgBangCap;
    private RadioButton rbTrungCap, rbCaoDang, rbDaiHoc;
    private CheckBox cbDocSach, cbDocBao, cbDocCoding;
    private Button btnGuiThongTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_th2_bai9);

        etHoTen = findViewById(R.id.etHoTen);
        etCMND = findViewById(R.id.etCMND);
        etThongTinBoSung = findViewById(R.id.etThongTinBoSung);
        rgBangCap = findViewById(R.id.rgBangCap);
        rbTrungCap = findViewById(R.id.rbTrungCap);
        rbCaoDang = findViewById(R.id.rbCaoDang);
        rbDaiHoc = findViewById(R.id.rbDaiHoc);
        cbDocSach = findViewById(R.id.cbDocSach);
        cbDocBao = findViewById(R.id.cbDocBao);
        cbDocCoding = findViewById(R.id.cbDocCoding);
        btnGuiThongTin = findViewById(R.id.btnGuiThongTin);

        // Handle button click event
        btnGuiThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    showAlertDialog();
                }
            }
        });
    }

    private boolean validateInputs() {
        String hoTen = etHoTen.getText().toString().trim();
        String cmnd = etCMND.getText().toString().trim();

        // Validate Họ tên
        if (hoTen.isEmpty() || hoTen.length() < 3) {
            Toast.makeText(this, "Tên người không được để trống và phải có ít nhất 3 ký tự", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Validate CMND
        if (cmnd.isEmpty() || cmnd.length() != 9 || !cmnd.matches("\\d+")) {
            Toast.makeText(this, "CMND phải là số và có đúng 9 chữ số", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Validate Sở thích
        if (!cbDocSach.isChecked() && !cbDocBao.isChecked() && !cbDocCoding.isChecked()) {
            Toast.makeText(this, "Sở thích phải chọn ít nhất 1 lựa chọn", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void showAlertDialog() {
        String hoTen = etHoTen.getText().toString().trim();
        String cmnd = etCMND.getText().toString().trim();
        String bangCap = ((RadioButton) findViewById(rgBangCap.getCheckedRadioButtonId())).getText().toString();
        StringBuilder soThich = new StringBuilder();

        if (cbDocSach.isChecked()) soThich.append("Đọc sách ");
        if (cbDocBao.isChecked()) soThich.append("Đọc báo ");
        if (cbDocCoding.isChecked()) soThich.append("Đọc coding ");

        String thongTinBoSung = etThongTinBoSung.getText().toString().trim();

        // Create the alert dialog
        new AlertDialog.Builder(this)
                .setTitle("Thông tin cá nhân")
                .setMessage("Họ tên: " + hoTen + "\nCMND: " + cmnd + "\nBằng cấp: " + bangCap +
                        "\nSở thích: " + soThich.toString() + "\nThông tin bổ sung: " + thongTinBoSung)
                .setPositiveButton("OK", null)
                .show();

    }
}