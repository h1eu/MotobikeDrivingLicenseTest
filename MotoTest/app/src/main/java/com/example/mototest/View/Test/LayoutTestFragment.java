package com.example.mototest.View.Test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mototest.Model.Test;
import com.example.mototest.R;

public class LayoutTestFragment extends Fragment {
    private TextView tvquestitle ;
    private View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_layout_test, container, false);

        tvquestitle=v.findViewById(R.id.tv_question_title);

        Bundle bundle=getArguments();
        if(bundle!=null)
        {
            Test test = (Test) bundle.get("question");
            if(test !=null) {
                tvquestitle.setText(test.getListQuestion());
            }
        }


        // Inflate the layout for this fragment
        return v;
    }
}