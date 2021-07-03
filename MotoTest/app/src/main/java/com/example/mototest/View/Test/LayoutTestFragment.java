package com.example.mototest.View.Test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mototest.Model.Question;
import com.example.mototest.Model.Test;
import com.example.mototest.R;

public class LayoutTestFragment extends Fragment {
    private TextView tvquestitle ;
    private LinearLayout layout1;
    private CheckBox checkBox2;
    private View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_layout_question, container, false);

        tvquestitle=v.findViewById(R.id.tv_question_title);
        layout1=v.findViewById(R.id.layout_answer1);
        checkBox2=v.findViewById(R.id.checkbox2);
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"click1",Toast.LENGTH_SHORT).show();
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"click2",Toast.LENGTH_SHORT).show();
            }
        });
        Bundle bundle=getArguments();
        if(bundle!=null)
        {
            Question question = (Question) bundle.get("idquestion");
            if(question !=null) {
                tvquestitle.setText(Integer.toString(question.getIdquestion()));
            }
        }


        // Inflate the layout for this fragment
        return v;
    }
}