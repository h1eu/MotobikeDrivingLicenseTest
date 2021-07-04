package com.example.mototest.View.Test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mototest.Model.Question;
import com.example.mototest.R;

import java.util.ArrayList;

public class CheckAnserAdapter extends BaseAdapter {
    ArrayList<String> arrayListanser;
    LayoutInflater inflater;

    public CheckAnserAdapter(ArrayList<String> arrayListanser, Context context) {
        this.arrayListanser = arrayListanser;
        inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayListanser.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListanser.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String data=(String) getItem(position);
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.grid_items_question,null);
            viewHolder.tvnum=(TextView) convertView.findViewById(R.id.tv_ansernum);
            viewHolder.tvanser=(TextView) convertView.findViewById(R.id.tv_anser_content);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        int i=position+1;
        viewHolder.tvnum.setText("Câu "+i+": ");
        viewHolder.tvanser.setText(data);
        return convertView;
    }
    private static class ViewHolder{
        TextView tvnum, tvanser;

    }

}
