package com.example.mototest.View.Test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.mototest.Api.ApiService;
import com.example.mototest.Api.Status;
import com.example.mototest.R;
import com.example.mototest.View.Admin.testmanagerDirections;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestAdapter extends ArrayAdapter<String> {
    public static boolean isdel=false;
    private ArrayList<String> testArrayList=new ArrayList<>();
    public TestAdapter(@NonNull Context context, ArrayList<String> testArrayList) {
        super(context, 0,testArrayList);
        this.testArrayList=testArrayList;
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
        ImageView img_delTest = convertView.findViewById(R.id.img_delTest);
        img_delTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isdel=true;
                delTest(testArrayList.get(position));
                Toast.makeText(getContext(), "Hay f5 -> da xoa test:"+testArrayList.get(position), Toast.LENGTH_SHORT).show();
                isdel=false;
            }
        });
//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "da click vao detail", Toast.LENGTH_SHORT).show();
//                if(!isdel){

//                    Toast.makeText(getContext(), "da chuyen sang detail", Toast.LENGTH_SHORT).show();
//
//                 }
//            }
//        });



        String test=getItem(position);
        if(test!=null){
            test_name.setText("Đề "+test);
        }

        return convertView;
    }

    private void delTest(String testId){
        ApiService.apiservice.querryTest("delTest",testId,"0").enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                Toast.makeText(getContext(),"Xoa thanh cong",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                Toast.makeText(getContext(),"Xoa that bai",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
