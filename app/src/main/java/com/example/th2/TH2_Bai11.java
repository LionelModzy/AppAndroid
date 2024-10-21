package com.example.th2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TH2_Bai11 extends AppCompatActivity {
    private TextView tvSelectedItem;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_th2_bai11);

        tvSelectedItem = findViewById(R.id.tv_selected_item);
        listView = findViewById(R.id.list_view);

        // Lấy mảng chuỗi từ resources
        String[] items = getResources().getStringArray(R.array.items_array);

        // Tạo ArrayAdapter và thiết lập cho ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        // Thiết lập sự kiện khi click vào từng phần tử
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lấy giá trị và vị trí của phần tử được click
                String selectedItem = items[position];
                tvSelectedItem.setText("Vị trí: " + position + ", Giá trị: " + selectedItem);
            }
        });
    }
}