package com.example.mototest.View.Test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.mototest.Model.Question;
import com.example.mototest.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Question> {
    Context context;
    List<Question> arrayList;
    int layoutResource; //Hàm khởi tạo cho CustomArrayAdapter
    public CustomAdapter(Context context, int resource, List<Question> objects)
    {
        super(context, resource, objects); this.context = context; this.arrayList = objects; this.layoutResource = resource;
    }
    @NonNull
    @Override //Hàm khởi tạo cho các dòng để hiển thị trên ListView
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
//        arrayList.get(position).getName()
        convertView = inflater.inflate(layoutResource,null); //Hàm khởi thêm dữ lieu vào các View từ arrayList thông qua position
        TextView txt1 = (TextView)convertView.findViewById(R.id.tv_answer1_content); txt1.setText("1");
        TextView txt2 = (TextView)convertView.findViewById(R.id.tv_answer2_content); txt2.setText("2");
        TextView txt3 = (TextView)convertView.findViewById(R.id.tv_answer3_content); txt3.setText("3");
        TextView txt4 = (TextView)convertView.findViewById(R.id.tv_answer4_content); txt4.setText("4");

        return convertView;
    }
}