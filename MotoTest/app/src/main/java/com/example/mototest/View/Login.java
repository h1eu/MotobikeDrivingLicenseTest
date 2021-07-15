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
//                Dialog dialog=new Dialog(activity);
//                dialog.setContentView(R.layout.dialog_custom);
////                customDialog.showdialog(activity,"Đăng Nhập","Bạn có đăng nhập không hahahahahahakkkkkkkkkkkkkk ?");
////                dialog.setTitle("Bạn có đăng nhập không hahahahahahakkkkkkkkkkkkkk ?");
//                Button btn_yes=(Button)dialog.findViewById(R.id.btn_yes);
//                Button btn_no=(Button)dialog.findViewById(R.id.btn_no);
//                TextView tv_dialog_title= dialog.findViewById(R.id.tv_dialog_title);
//                TextView tv_dialog_content=dialog.findViewById(R.id.tv_dialog_content);
//                tv_dialog_title.setText("Xác nhận");
//                tv_dialog_content.setText("Bạn chắc chứ");
//                btn_yes.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                    }
//                });
//                btn_no.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.dismiss();
//                    }
//                });
//                dialog.show();
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
//                Bundle bundle=new Bundle();
//                bundle.putString("Username",user.getUsername());
//                bundle.putString("Name",user.getName());

                ((InfoAcc) getApplication()).setUsername(user.getUsername());
                ((InfoAcc) getApplication()).setName(user.getName());
                ((InfoAcc) getApplication()).setIduser(user.getIduser());
                ((InfoAcc) getApplication()).setPermission(user.getPermission());
                ((InfoAcc) getApplication()).setAccess_token(user.getAccess_token());
                Intent intent=new Intent(Login.this, MainActivity.class);
//                intent.putExtras(bundle);
                startActivity(intent);
                Toast.makeText(getBaseContext(),"OK -> LOGIN SOON",Toast.LENGTH_SHORT).show();
                Toast.makeText(getBaseContext(),user.getAccess_token(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getBaseContext(),"SAI TK HOAC MK",Toast.LENGTH_SHORT).show();
            }
        });
    }
}