package com.example.th2;

import android.app.ListActivity; // Đảm bảo sử dụng ListActivity
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TH2_Bai13 extends ListActivity { // Kế thừa từ ListActivity
    private TextView tvSelectedItem;
    private String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th2_bai13); // Gán layout cho ListActivity

        tvSelectedItem = findViewById(R.id.tv_selected_item);

        // Tạo ArrayAdapter và thiết lập cho ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter); // Thiết lập adapter cho ListActivity

        // Thiết lập sự kiện khi click vào từng phần tử của ListView
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lấy giá trị của phần tử được click
                String selectedItem = items[position];
                tvSelectedItem.setText("Vị trí: " + position + ", Giá trị: " + selectedItem);
            }
        });
    }
}
