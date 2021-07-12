package com.example.mototest.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mototest.R;

public class ForgetPass extends AppCompatActivity {
    Button btn_comfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        btn_comfirm=(Button)findViewById(R.id.btn_comfirm);
        btn_comfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ForgetPass.this,Login.class);
                startActivity(intent);
            }
        });
    }
}