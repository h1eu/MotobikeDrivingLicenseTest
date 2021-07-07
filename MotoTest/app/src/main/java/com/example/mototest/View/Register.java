package com.example.mototest.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mototest.Api.ApiService;
import com.example.mototest.Model.User;
import com.example.mototest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
    private EditText edt_res_username,edt_res_name,edt_res_password,edt_res_ComPassword;
    private Button btn_res_register;
    TextView tv_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn_res_register=findViewById(R.id.btn_res_register);
        edt_res_username=findViewById(R.id.edt_res_username);
        edt_res_name=findViewById(R.id.edt_res_name);
        edt_res_password=findViewById(R.id.edt_res_password);
        edt_res_ComPassword=findViewById(R.id.edt_res_ComPassword);
        tv_login = (TextView)findViewById(R.id.tv_login);
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });
        btn_res_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_res_password.getText().toString().equals(edt_res_ComPassword.getText().toString())){
//                    Toast.makeText(getBaseContext(),"GOI API REG",Toast.LENGTH_SHORT).show();
                    register();
                }
                else
                {
                    Toast.makeText(getBaseContext(),"Pass khong trung nhau",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void register(){
        ApiService.apiservice.register(edt_res_name.getText().toString(),edt_res_username.getText().toString(),edt_res_password.getText().toString()).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user =response.body();
                if(user.getUsername()!=null)
                Toast.makeText(getBaseContext(),"REG THANH CONG",Toast.LENGTH_SHORT).show();
                Toast.makeText(getBaseContext(),"Ma RECOVER PASS:"+user.getRecover(),Toast.LENGTH_SHORT).show();
//                CHUYEN SANG VIEW LOGIN
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getBaseContext(),"TEN TK DA TON TAI",Toast.LENGTH_SHORT).show();
            }
        });
    }
}