package com.example.mototest.View.Test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mototest.Model.Test;
import com.example.mototest.R;

import org.jetbrains.annotations.NotNull;

public class LayoutTestFragment extends Fragment {
    private TextView tvquestitle ;
    private View v;
    private LinearLayout layout1;
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
                tvquestitle.setText(test.getListquestion());
            }
        }
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layout1 = (LinearLayout) view.findViewById(R.id.layout_answer1);
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("da click","click");
                Toast.makeText(getContext(),"click dap an 1",Toast.LENGTH_SHORT).show();

            }
        });
        ImageView iv_description = view.findViewById(R.id.iv_description);
        iv_description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("da click","click");
                Toast.makeText(getContext(),"click dap an 1",Toast.LENGTH_SHORT).show();

            }
        });
    }
}