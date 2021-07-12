package com.example.mototest.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mototest.MainActivity;
import com.example.mototest.R;
import com.example.mototest.View.Test.Result;

public class Comment extends AppCompatActivity {
    private ImageView toolbar_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        toolbar_back=(ImageView) findViewById(R.id.iv_toolbar_back);

        toolbar_back.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Comment.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}