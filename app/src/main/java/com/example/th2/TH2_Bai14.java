package com.example.th2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class TH2_Bai14 extends AppCompatActivity {
    private ListView listView;
    private TextView tvSelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th2_bai14);

        listView = findViewById(R.id.list_view);
        tvSelectedItem = findViewById(R.id.tv_selected_item);

        // Tạo danh sách dữ liệu
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("Apple");
        items.add("Cat");
        items.add("Dog");
        items.add("Elephant");
        items.add("Bird");

        // Tạo và thiết lập CustomAdapter
        CustomAdapter adapter = new CustomAdapter(this, items);
        listView.setAdapter(adapter);

        // Thiết lập sự kiện khi click vào từng phần tử của ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = items.get(position);
                tvSelectedItem.setText("Đã chọn: " + selectedItem);
            }
        });
    }
}
