package com.example.th2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import androidx.activity.EdgeToEdge;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TH2_Bai12 extends AppCompatActivity {
    private EditText etInputName;
    private Button btnAdd;
    private TextView tvSelectedItem;
    private ListView listView;
    private ArrayList<String> nameList;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_th2_bai12);

        etInputName = findViewById(R.id.et_input_name);
        btnAdd = findViewById(R.id.btn_add);
        tvSelectedItem = findViewById(R.id.tv_selected_item);
        listView = findViewById(R.id.list_view);

        // Khởi tạo ArrayList và ArrayAdapter
        nameList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nameList);
        listView.setAdapter(adapter);

        // Thiết lập sự kiện cho nút Nhập
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etInputName.getText().toString().trim();
                if (!name.isEmpty()) {
                    nameList.add(name);  // Thêm tên vào ArrayList
                    adapter.notifyDataSetChanged();  // Cập nhật ListView
                    etInputName.setText("");  // Xóa trắng EditText
                }
            }
        });

        // Thiết lập sự kiện khi click vào từng phần tử của ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lấy giá trị và vị trí của phần tử được click
                String selectedItem = nameList.get(position);
                tvSelectedItem.setText("Vị trí: " + position + ", Giá trị: " + selectedItem);
            }
        });
    }
}