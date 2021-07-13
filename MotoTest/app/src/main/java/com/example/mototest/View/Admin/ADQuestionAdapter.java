package com.example.mototest.View.Admin;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mototest.Model.Question;
import com.example.mototest.Model.Test;
import com.example.mototest.R;
import com.example.mototest.View.Test.LayoutTest;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ADQuestionAdapter extends ArrayAdapter<Question> {
    Context context;
    ArrayList<Question> arrayList;
    ArrayList<Integer> addQS = new ArrayList<>(),rmQS=new ArrayList<>();
    int layoutResource; //Hàm khởi tạo cho CustomArrayAdapter


    public ADQuestionAdapter(@NonNull @NotNull Context context, int resource, ArrayList<Question> arrayList) {
        super(context, resource, arrayList);
        this.arrayList = arrayList;
        this.context = context;
        this.layoutResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//            Log.e("Position =",Integer.toString(position));
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.fragment_rowquestion,parent,false);

            if(rmQS.indexOf(position)!=-1){
                convertView.setBackgroundColor(Color.parseColor("#FFF86E6E"));
            }
            if(addQS.indexOf(position)!=-1)
                convertView.setBackgroundColor(Color.parseColor("#81C784"));
            TextView tv_qsform = (TextView) convertView.findViewById(R.id.tv_questionform);
            TextView tv_qscontent = (TextView) convertView.findViewById(R.id.tv_qscontent);
            TextView tv_da1 = (TextView) convertView.findViewById(R.id.tv_da1);
            TextView tv_da2 = (TextView) convertView.findViewById(R.id.tv_da2);
            TextView tv_da3 = (TextView) convertView.findViewById(R.id.tv_da3);
            TextView tv_da4 = (TextView) convertView.findViewById(R.id.tv_da4);
            TextView tv_dadung = (TextView) convertView.findViewById(R.id.tv_dadung);
            TextView tv_IdQues = (TextView) convertView.findViewById(R.id.tv_IdQues);
            tv_IdQues.setText(Integer.toString(arrayList.get(position).getIdquestion()));
            tv_qsform.setText(arrayList.get(position).getQuestionform());
            tv_qscontent.setText(arrayList.get(position).getContent());
            tv_da1.setText(arrayList.get(position).getDa1());
            tv_da2.setText(arrayList.get(position).getDa2());
            tv_da3.setText(arrayList.get(position).getDa3());
            tv_da4.setText(arrayList.get(position).getDa4());
            tv_dadung.setText(arrayList.get(position).getDadung());
//            if(position==current_index)
        return convertView;
    }

    public void notifyDataSetChanged(int position,int type) {
        super.notifyDataSetChanged();
        if(type==-2)
            rmQS.remove(position);
        if(type==2)
            rmQS.add(position);
        if(type==-1)
            addQS.remove(position);
        if(type==1)
            addQS.add(position);
        Toast.makeText(getContext(),"co thay doi"+Integer.toString(position),Toast.LENGTH_SHORT).show();


    }
}
