package com.example.mototest.View.Comment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mototest.Api.AllCmt;
import com.example.mototest.Api.ApiService;
import com.example.mototest.MainActivity;
import com.example.mototest.Model.Comment;
import com.example.mototest.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class comment extends AppCompatActivity {
    private ImageView toolbar_back;
    private ArrayList<Comment> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        toolbar_back=(ImageView) findViewById(R.id.iv_toolbar_back);

        toolbar_back.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(comment.this, MainActivity.class);
                startActivity(intent1);
            }
        });
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int Testid = bundle.getInt("TestId");
        getComment(Testid);
//        Toast.makeText(this,Integer.toString(Testid),Toast.LENGTH_SHORT).show();
    }
    private void getComment(Integer Testid){
        ApiService.apiservice.getAllCmt("getAllCmt",Integer.toString(Testid)).enqueue(new Callback<AllCmt>() {
            @Override
            public void onResponse(Call<AllCmt> call, Response<AllCmt> response) {
                AllCmt allCmt = response.body();
                arrayList = allCmt.getAllCmt();
                Log.e("cmt:",arrayList.get(0).getContent());
            }

            @Override
            public void onFailure(Call<AllCmt> call, Throwable t) {
                Toast.makeText(getBaseContext(),"GET ALL CMT FAIL",Toast.LENGTH_SHORT).show();
            }
        });
    }
}