package com.example.mototest.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mototest.Api.ApiService;
import com.example.mototest.Api.InfoAcc;
import com.example.mototest.MainActivity;
import com.example.mototest.Model.User;
import com.example.mototest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    Button btn_login,btn_res;
    TextView tv_res,tv_forgetpass;
    EditText edt_usn_login,edt_pass_login;
    private int i=0;
    Activity activity=this;
    Dialog dialog2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login = (Button)findViewById(R.id.btn_login);
        tv_res = (TextView) findViewById(R.id.tv_register);
        tv_forgetpass=(TextView) findViewById(R.id.tv_forgetpass);
        edt_usn_login=(EditText)findViewById(R.id.edt_usn_login);
        edt_pass_login=(EditText)findViewById(R.id.edt_pass_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
                dialog2=new Dialog(activity);
                dialog2.setContentView(R.layout.loading);
                dialog2.show();
            }
        });
        tv_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
        tv_forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,ForgetPass.class);
                startActivity(intent);
            }
        });
    }

    private void login(){
        ApiService.apiservice.login(edt_usn_login.getText().toString(),edt_pass_login.getText().toString()).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user =response.body();
                ((InfoAcc) getApplication()).setUsername(user.getUsername());
                ((InfoAcc) getApplication()).setName(user.getName());
                ((InfoAcc) getApplication()).setIduser(user.getIduser());
                ((InfoAcc) getApplication()).setPermission(user.getPermission());
                ((InfoAcc) getApplication()).setAccess_token(user.getAccess_token());
                Intent intent=new Intent(Login.this, MainActivity.class);
                dialog2.dismiss();
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getBaseContext(),"Sai tài khoản hoặc mật khẩu",Toast.LENGTH_SHORT).show();
                dialog2.dismiss();
            }
        });
    }
}