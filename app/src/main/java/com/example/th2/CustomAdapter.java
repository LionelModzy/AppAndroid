package com.example.th2;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final List<String> values;

    public CustomAdapter(Context context, List<String> values) {
        super(context, R.layout.layout_list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout_list_item, parent, false);

        ImageView imageView = rowView.findViewById(R.id.image_view);
        TextView textView = rowView.findViewById(R.id.text_view);

        String item = values.get(position);
        textView.setText(item);

        // Thiết lập hình ảnh dựa trên nội dung
        if (item.length() <= 3) {
            imageView.setImageResource(R.drawable.star_image); // Thay thế bằng hình ngôi sao
        } else {
            imageView.setImageResource(R.drawable.globe_image); // Thay thế bằng hình địa cầu
        }

        return rowView;
    }
}

