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
import com.example.mototest.MainActivity;
import com.example.mototest.Model.User;
import com.example.mototest.R;
import com.example.mototest.View.Test.LayoutTest;
import com.example.mototest.View.Test.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    Button btn_login,btn_res;
    TextView tv_res,tv_forgetpass;
    EditText edt_usn_login,edt_pass_login;
    private int i=0;
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
//                Intent intent=new Intent(Login.this,Register.class);
//                startActivity(intent);
                login();


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
//        User user = new User(1,"hieulaptop","trinhhieu","gido","abc");
        ApiService.apiservice.login(edt_usn_login.getText().toString(),edt_pass_login.getText().toString()).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
//                Toast.makeText(getBaseContext(),"CALL API SUCCESS",Toast.LENGTH_SHORT).show();
                User user =response.body();
                Bundle bundle=new Bundle();
                bundle.putString("Username",user.getUsername());
                bundle.putString("Name",user.getName());
                Intent intent=new Intent(Login.this, MainActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                Toast.makeText(getBaseContext(),"OK -> LOGIN SOON",Toast.LENGTH_SHORT).show();
//                Toast.makeText(getBaseContext(),user.getUsername()+"avbababab",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getBaseContext(),"SAI TK HOAC MK",Toast.LENGTH_SHORT).show();
            }
        });
    }
}