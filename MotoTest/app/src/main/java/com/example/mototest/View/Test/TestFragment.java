package com.example.mototest.View.Test;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.mototest.Model.Test;
import com.example.mototest.R;
import com.example.mototest.View.Login;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class TestFragment extends Fragment  {
    Button button;
    TestAdapter testAdapter;
    ListView listViewtest;
    ArrayList<Test> testArrayList = new ArrayList<Test>();

    public TestFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_test,container,false);

        // Inflate the layout for this fragment
        return v;

    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    //        String[] test={"Đề 1","Đề 2","Đề 3","Đề 4"};
//        ListView listView=(ListView)view.findViewById(R.id.lv_test);
//        ArrayAdapter<String> adapter=new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,test);
//
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(this);
            listViewtest=(ListView)getActivity().findViewById(R.id.lv_test);
            testArrayList.add(new Test(1,1,20));
            testArrayList.add(new Test(2,1,20));
            testArrayList.add(new Test(3,1,20));
            testArrayList.add(new Test(4,1,20));
            testArrayList.add(new Test(5,1,20));
            testArrayList.add(new Test(6,1,20));
            testArrayList.add(new Test(7,1,20));
            testArrayList.add(new Test(8,1,20));

            testAdapter=new TestAdapter(getActivity(),testArrayList);
            listViewtest.setAdapter(testAdapter);
            listViewtest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent=new Intent();
                    intent.setClass(getActivity(), LayoutTest.class);
                    getActivity().startActivity(intent);
                }
            });
    }



//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        if(position==0){
//            Intent intent=new Intent();
//            intent.setClass(getActivity(), LayoutTest.class);
//            getActivity().startActivity(intent);
//
//        }
//        if(position==1){
//            Toast.makeText(getActivity(),"đề 1",Toast.LENGTH_SHORT).show();
//        }
//        if(position==2){
//            Toast.makeText(getActivity(),"đề 1",Toast.LENGTH_SHORT).show();
//        }
//        if(position==3){
//            Toast.makeText(getActivity(),"đề 1",Toast.LENGTH_SHORT).show();
//        }
//
//
//    }
}