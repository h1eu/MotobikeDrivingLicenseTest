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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.mototest.Api.Alltest;
import com.example.mototest.Api.ApiService;
import com.example.mototest.Model.Question;
import com.example.mototest.Model.Test;
import com.example.mototest.R;
import com.example.mototest.View.Login;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TestFragment extends Fragment  {
    Button button;
    TestAdapter testAdapter;
    ListView listViewtest;
    ArrayList<String> testArrayList = new ArrayList<String>();

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

        ApiService.apiservice.getAllTest("getAllTest").enqueue(new Callback<Alltest>() {
            @Override
            public void onResponse(Call<Alltest> call, Response<Alltest> response) {
                listViewtest=(ListView)getActivity().findViewById(R.id.lv_test);
                Toast.makeText(getContext(), "Call API SUCCESS", Toast.LENGTH_SHORT).show();
                Alltest alltest=response.body();
                ArrayList<Test> allidTest=alltest.getAllTest();
//                Log.e("testid 1:",Integer.toString(alltest.getAllTest().get(0).getIdtest()));
                for(Test t : allidTest)
                {
                    testArrayList.add(Integer.toString(t.getIdtest()));
                }
                testAdapter=new TestAdapter(getActivity(),testArrayList);
                listViewtest.setAdapter(testAdapter);
                listViewtest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Bundle bundle=new Bundle();
                        bundle.putString("Idtest", testArrayList.get(position));
                        Intent intent=new Intent();
                        intent.putExtras(bundle);
                        intent.setClass(getActivity(), LayoutTest.class);
                        getActivity().startActivity(intent);
                    }
                });
            }
            @Override
            public void onFailure(Call<Alltest> call, Throwable t) {
                Toast.makeText(getContext(), "Call API FAIL", Toast.LENGTH_SHORT).show();
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