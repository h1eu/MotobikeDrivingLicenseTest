package com.example.mototest.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mototest.Api.AllQues;
import com.example.mototest.Api.AllTestQS;
import com.example.mototest.Api.Alltest;
import com.example.mototest.Api.ApiService;
import com.example.mototest.Api.InfoAcc;
import com.example.mototest.Api.TestQS;
import com.example.mototest.MainActivity;
import com.example.mototest.Model.DBHandler;
import com.example.mototest.Model.MyReceiver;
import com.example.mototest.Model.Question;
import com.example.mototest.Model.Test;
import com.example.mototest.Model.User;
import com.example.mototest.R;
import com.example.mototest.View.Admin.testmanager;
//import com.example.mototest.View.Admin;
import com.example.mototest.View.Test.TestAdapter;

import java.util.ArrayList;

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
//    Test test = new Test(4,null,null);
//    Question question = new Question(3,"d","f","d","a","a","a","a","1");
    private DBHandler dbHandler ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(mNetworkReceiver2, filter);
        dbHandler = new DBHandler(this);
        btn_login = (Button)findViewById(R.id.btn_login);
        tv_res = (TextView) findViewById(R.id.tv_register);
        tv_forgetpass=(TextView) findViewById(R.id.tv_forgetpass);
        edt_usn_login=(EditText)findViewById(R.id.edt_usn_login);
        edt_pass_login=(EditText)findViewById(R.id.edt_pass_login);
        if(((InfoAcc) activity.getApplication()).getMode().equals("offline")){
            btn_login.setText("Vào thi offline");
            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }
        else{
            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog2=new Dialog(activity);
                    dialog2.setContentView(R.layout.loading);
                    dialog2.show();
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
//                finish();
                unregisterReceiver(mNetworkReceiver2);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getBaseContext(),"Sai tài khoản hoặc mật khẩu",Toast.LENGTH_SHORT).show();
                dialog2.dismiss();
            }
        });
    }

    private final MyReceiver mNetworkReceiver2 = new MyReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            boolean isnotConnected = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            if (isnotConnected) {
                if(!((InfoAcc) activity.getApplication()).getMode().equals("offline")){
                    Dialog dialog = new Dialog(activity);
//        View view  = getActivity().getLayoutInflater().inflate(R.layout.dialog_custom, null);
                    dialog.setContentView(R.layout.dialog_custom);

                    Button btn_yes = (Button) dialog.findViewById(R.id.btn_yes);
                    Button btn_no = (Button) dialog.findViewById(R.id.btn_no);
                    TextView tv_dialog_title = dialog.findViewById(R.id.tv_dialog_title);
                    TextView tv_dialog_content = dialog.findViewById(R.id.tv_dialog_content);
                    tv_dialog_title.setText("Xác nhận chuyển hướng");
                    tv_dialog_content.setText("Bạn đã mất kết nối mạng, chuyển qua chế độ offline?");

                    btn_yes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            ((InfoAcc) activity.getApplication()).setMode("offline");
                            ((InfoAcc) activity.getApplication()).setIduser(-1);
                            ((InfoAcc) activity.getApplication()).setUsername("offline");
                            ((InfoAcc) activity.getApplication()).setName("offline");
                            ((InfoAcc) activity.getApplication()).setPermission("none");
                            ((InfoAcc) activity.getApplication()).setAccess_token("none");
                            btn_login.setText("Vào thi offline");
                            btn_login.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent=new Intent(Login.this, MainActivity.class);
                                    startActivity(intent);
                                    unregisterReceiver(mNetworkReceiver2);
                                }
                            });
                        }
                    });
                    btn_no.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                    Toast.makeText(context, "Nhận ở bên login", Toast.LENGTH_LONG).show();
                }
            } else {
                if(((InfoAcc) activity.getApplication()).getMode().equals("offline"))
                    Toast.makeText(context, "Đã online đăng nhập lại để chuyển chế độ", Toast.LENGTH_LONG).show();
                ((InfoAcc) activity.getApplication()).setMode("online");
                btn_login.setText("Đăng nhập");
                btn_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog2=new Dialog(activity);
                        dialog2.setContentView(R.layout.loading);
                        dialog2.show();
                        login();
                    }
                });
            }
        }
    };


}