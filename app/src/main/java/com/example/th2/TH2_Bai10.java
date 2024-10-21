package com.example.th2;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TH2_Bai10 extends AppCompatActivity {
    private EditText etTenKH, etSoLuongSach, etThanhTien, etTongSoKH, etTongSoKHVip, etTongDoanhThu;
    private CheckBox cbKhachHangVip;
    private Button btnTinhTT, btnTiep, btnThongKe;
    private ImageButton btnThoat;

    private int tongSoKH = 0;
    private int tongSoKHVip = 0;
    private double tongDoanhThu = 0;

    // Danh sách lưu thông tin các khách hàng
    private ArrayList<Double> danhSachHoaDon = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_th2_bai10);

        etTenKH = findViewById(R.id.et_ten_khach_hang);
        etSoLuongSach = findViewById(R.id.et_so_luong_sach);
        etThanhTien = findViewById(R.id.et_thanh_tien);
        cbKhachHangVip = findViewById(R.id.cb_khach_hang_vip);
        btnTinhTT = findViewById(R.id.btn_tinh_tt);
        btnTiep = findViewById(R.id.btn_tiep);
        btnThongKe = findViewById(R.id.btn_thong_ke);
        etTongSoKH = findViewById(R.id.et_tong_so_kh);
        etTongSoKHVip = findViewById(R.id.et_tong_so_kh_vip);
        etTongDoanhThu = findViewById(R.id.et_tong_doanh_thu);
        btnThoat = findViewById(R.id.btn_thoat);

        // Sự kiện tính thành tiền
        btnTinhTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhThanhTien();
            }
        });

        // Sự kiện tiếp tục
        btnTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                luuHoaDon();
            }
        });

        // Sự kiện thống kê
        btnThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thongKe();
            }
        });

        // Sự kiện thoát
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thoatChuongTrinh();
            }
        });
    }

    private void tinhThanhTien() {
        String tenKH = etTenKH.getText().toString().trim();
        String soLuongSachStr = etSoLuongSach.getText().toString().trim();

        if (tenKH.isEmpty() || soLuongSachStr.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            return;
        }

        int soLuongSach = Integer.parseInt(soLuongSachStr);
        double donGia = 20000;
        double thanhTien = soLuongSach * donGia;

        if (cbKhachHangVip.isChecked()) {
            thanhTien *= 0.9; // Giảm 10%
        }

        etThanhTien.setText(String.valueOf(thanhTien));
    }

    private void luuHoaDon() {
        String thanhTienStr = etThanhTien.getText().toString().trim();

        if (!thanhTienStr.isEmpty()) {
            double thanhTien = Double.parseDouble(thanhTienStr);
            danhSachHoaDon.add(thanhTien);

            tongSoKH++;
            if (cbKhachHangVip.isChecked()) {
                tongSoKHVip++;
            }
            tongDoanhThu += thanhTien;

            // Xóa trắng thông tin
            etTenKH.setText("");
            etSoLuongSach.setText("");
            etThanhTien.setText("");
            cbKhachHangVip.setChecked(false);

            etTenKH.requestFocus();
        } else {
            Toast.makeText(this, "Vui lòng tính thành tiền trước khi tiếp tục!", Toast.LENGTH_SHORT).show();
        }
    }

    private void thongKe() {
        etTongSoKH.setText(String.valueOf(tongSoKH));
        etTongSoKHVip.setText(String.valueOf(tongSoKHVip));
        etTongDoanhThu.setText(String.valueOf(tongDoanhThu));
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