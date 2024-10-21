package com.example.th2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TH2_Bai15 extends AppCompatActivity {
    private Spinner spinnerCategories;
    private ListView listViewProducts;

    private List<String> categories;
    private HashMap<String, List<String>> productsMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th2_bai15);

        spinnerCategories = findViewById(R.id.spinner_categories);
        listViewProducts = findViewById(R.id.list_view_products);

        // Tạo danh sách danh mục sản phẩm
        categories = new ArrayList<>();
        categories.add("Điện thoại");
        categories.add("Máy tính");
        categories.add("Đồng hồ");

        // Tạo danh sách sản phẩm tương ứng
        productsMap = new HashMap<>();
        productsMap.put("Điện thoại", createPhoneList());
        productsMap.put("Máy tính", createComputerList());
        productsMap.put("Đồng hồ", createWatchList());

        // Thiết lập Adapter cho Spinner
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, categories);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategories.setAdapter(categoryAdapter);

        // Thiết lập sự kiện khi chọn danh mục
        spinnerCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = categories.get(position);
                updateProductList(selectedCategory);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                listViewProducts.setAdapter(null);
            }
        });
    }

    // Hàm tạo danh sách điện thoại
    private List<String> createPhoneList() {
        List<String> phones = new ArrayList<>();
        phones.add("Nokia");
        phones.add("Xiaomi");
        phones.add("Oppo");
        phones.add("Samsung");
        phones.add("iPhone");
        return phones;
    }

    // Hàm tạo danh sách máy tính
    private List<String> createComputerList() {
        List<String> computers = new ArrayList<>();
        computers.add("Dell");
        computers.add("HP");
        computers.add("Lenovo");
        computers.add("Apple");
        return computers;
    }

    // Hàm tạo danh sách đồng hồ
    private List<String> createWatchList() {
        List<String> watches = new ArrayList<>();
        watches.add("Casio");
        watches.add("Rolex");
        watches.add("Fossil");
        watches.add("Seiko");
        return watches;
    }

    // Cập nhật danh sách sản phẩm cho ListView
    private void updateProductList(String category) {
        List<String> products = productsMap.get(category);
        ArrayAdapter<String> productAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, products);
        listViewProducts.setAdapter(productAdapter);

        // Thiết lập sự kiện khi chọn sản phẩm
        listViewProducts.setOnItemClickListener((parent, view, position, id) -> {
            String selectedProduct = products.get(position);
            Toast.makeText(TH2_Bai15.this, "Chi tiết: " + selectedProduct, Toast.LENGTH_SHORT).show();
        });
    }
}
