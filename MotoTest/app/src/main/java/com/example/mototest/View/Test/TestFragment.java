package com.example.mototest.View.Test;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.mototest.R;

import org.jetbrains.annotations.NotNull;


public class TestFragment extends Fragment implements AdapterView.OnItemClickListener {
    Button button;

    public TestFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_test,container,false);

        // Inflate the layout for this fragment
        return v;

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] test={"Đề 1","Đề 2","Đề 3","Đề 4"};
        ListView listView=(ListView)view.findViewById(R.id.lv_test);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,test);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position==0){
            Intent intent=new Intent();
            intent.setClass(getActivity(), LayoutTest.class);
            getActivity().startActivity(intent);

        }
        if(position==1){
            Toast.makeText(getActivity(),"đề 1",Toast.LENGTH_SHORT).show();
        }
        if(position==2){
            Toast.makeText(getActivity(),"đề 1",Toast.LENGTH_SHORT).show();
        }
        if(position==3){
            Toast.makeText(getActivity(),"đề 1",Toast.LENGTH_SHORT).show();
        } if(position==4){
            Toast.makeText(getActivity(),"đề 1",Toast.LENGTH_SHORT).show();
        } if(position==5){
            Toast.makeText(getActivity(),"đề 1",Toast.LENGTH_SHORT).show();
        }


    }
}