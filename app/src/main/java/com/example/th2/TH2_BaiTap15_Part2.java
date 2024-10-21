package com.example.th2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class TH2_BaiTap15_Part2 extends AppCompatActivity {
    private EditText editTask;
    private TextView txtDateTime;
    private Button btnDate, btnTime, btnAddTask, btnDeleteTask, btnExit;
    private ListView listTasks;
    private TextView txtCurrentDate, txtCurrentTime;
    private String selectedDate = "";
    private String selectedTime = "";
    private ArrayList<String> tasks = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private int selectedTaskIndex = -1;
    private EditText editContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_th2_bai_tap15_part2);

        editTask = findViewById(R.id.edtTask);
        txtDateTime = findViewById(R.id.txtDateTime);
        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);
        btnAddTask = findViewById(R.id.btnAddTask);
        btnDeleteTask = findViewById(R.id.btnDeleteTask);
        btnExit = findViewById(R.id.btnExit); // Tìm nút Thoát
        listTasks = findViewById(R.id.lstTasks);
        txtCurrentDate = findViewById(R.id.txtCurrentDate);
        txtCurrentTime = findViewById(R.id.txtCurrentTime);
        editContent = findViewById(R.id.edtContent);

        // Fetch and display current date
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(calendar.getTime());
        txtCurrentDate.setText("Ngày hiện tại: " + currentDate);

        // Fetch and display current time
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String currentTime = timeFormat.format(calendar.getTime());
        txtCurrentTime.setText("Giờ hiện tại: " + currentTime);
        // Thiết lập adapter cho ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, tasks);
        listTasks.setAdapter(adapter);
        listTasks.setChoiceMode(ListView.CHOICE_MODE_SINGLE); // Cho phép chọn một mục duy nhất

        // DatePickerDialog để chọn ngày
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        // TimePickerDialog để chọn giờ
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });

        // Nút Thêm công việc
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask();
            }
        });

        // Nút Xóa công việc
        btnDeleteTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteSelectedTask();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng ứng dụng
            }
        });

        // Lắng nghe sự kiện chọn công việc trong ListView
        listTasks.setOnItemClickListener((parent, view, position, id) -> {
            selectedTaskIndex = position; // Cập nhật chỉ số của công việc đã chọn
        });
    }

    // Hiển thị DatePickerDialog để chọn ngày
    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {
            selectedDate = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
            updateDateTimeText();
        }, year, month, day);
        datePickerDialog.show();
    }

    // Hiển thị TimePickerDialog để chọn giờ
    private void showTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view, hourOfDay, minute1) -> {
            selectedTime = hourOfDay + ":" + (minute1 < 10 ? "0" + minute1 : minute1);
            updateDateTimeText();
        }, hour, minute, true);
        timePickerDialog.show();
    }

    // Cập nhật TextView hiển thị ngày và giờ
    private void updateDateTimeText() {
        txtDateTime.setText("Ngày: " + selectedDate + " - Giờ: " + selectedTime);
    }

    // Thêm một công việc mới
    private void addTask() {
        String taskName = editTask.getText().toString();
        String taskContent = editContent.getText().toString(); // Get the content from the field

        if (!taskName.isEmpty() && !taskContent.isEmpty() && !selectedDate.isEmpty() && !selectedTime.isEmpty()) {
            // Format the task to include the content
            String task = "Công việc: "+ taskName + " - Nội dung: " + taskContent + " - Ngày: " + selectedDate + ", - Giờ: " + selectedTime;
            tasks.add(task);  // Add the task to the list
            adapter.notifyDataSetChanged();  // Update the ListView
            clearFields();  // Clear the fields after adding
        } else {
            Toast.makeText(TH2_BaiTap15_Part2.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
        }
    }


    // Xóa các trường nhập liệu
    private void clearFields() {
        editTask.setText("");
        editContent.setText(""); // Clear the content field
        txtDateTime.setText("");
        selectedDate = "";
        selectedTime = "";
    }


    // Xóa công việc đã chọn
    private void deleteSelectedTask() {
        if (selectedTaskIndex >= 0 && selectedTaskIndex < tasks.size()) {
            tasks.remove(selectedTaskIndex);
            adapter.notifyDataSetChanged();  // Cập nhật ListView
            selectedTaskIndex = -1;  // Đặt lại chỉ số chọn
        } else {
            Toast.makeText(TH2_BaiTap15_Part2.this, "Vui lòng chọn một công việc để xóa", Toast.LENGTH_SHORT).show();
        }
    }
}


