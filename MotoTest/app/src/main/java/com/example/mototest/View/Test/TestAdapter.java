package com.example.mototest.View.Test;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mototest.Model.Test;
import com.example.mototest.R;

import java.util.ArrayList;

public class TestAdapter extends ArrayAdapter<String> {
    public TestAdapter(@NonNull Context context, ArrayList<String> testArrayList) {
        super(context, 0,testArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null)
        {
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.items_test,parent,false);
        }
        TextView test_name=(TextView)convertView.findViewById(R.id.tv_test_name);

        String test=getItem(position);
        if(test!=null){
            test_name.setText("Đề "+test);
        }

        return convertView;
    }
}
