package com.example.mototest;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mototest.Api.AllQues;
import com.example.mototest.Api.AllTestQS;
import com.example.mototest.Api.ApiService;
import com.example.mototest.Api.InfoAcc;
import com.example.mototest.Api.TestQS;
import com.example.mototest.Model.DBHandler;
import com.example.mototest.Model.MyReceiver;
import com.example.mototest.Model.Question;
import com.example.mototest.View.Login;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.mototest.databinding.ActivityMainBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private TextView tvbackq,tvnextq,tvcurrentq,tvmaxq,tv_name_main,tv_username_main;
    private ViewPager viewPager;
    private View view;
    protected Question question;
    public int check=0;
    private Activity activity = this;
    private DBHandler dbHandler ;
    private MyReceiver mNetworkReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        dbHandler = new DBHandler(this);
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
//        mNetworkReceiver = new MyReceiver();
        this.registerReceiver(mNetworkReceiver2, filter);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_test, R.id.nav_test_random, R.id.nav_review, R.id.nav_tip,R.id.nav_change_pass,R.id.nav_logout,R.id.nav_dashboard)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        view=navigationView.getHeaderView(0);
        tv_name_main=view.findViewById(R.id.tv_name_main);
        tv_username_main=view.findViewById(R.id.tv_usn_main);
//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        if(bundle!=null) {
            tv_name_main.setText(((InfoAcc) getApplication()).getName());
            tv_username_main.setText(((InfoAcc) getApplication()).getUsername());
//        }
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
//                int id = item.getItemId();
//                if (id == R.id.nav_logout) {
//                    finish();
//                    return true;
//                }
//                return true;
//            }
//        });

        MenuItem dashboard = navigationView.getMenu().findItem(R.id.nav_dashboard);
        if(((InfoAcc) activity.getApplication()).getMode().equals("offline")){
            navigationView.getMenu().findItem(R.id.nav_dashboard).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_test_random).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_review).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_tip).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_change_pass).setVisible(false);
        }
        else
        {
            dbHandler.updateDB();
            insertTest();
            insertQues();
        }
        if(!((InfoAcc) getApplication()).getPermission().equals("admin")) dashboard.setVisible(false);
        MenuItem logoutItem = navigationView.getMenu().findItem(R.id.nav_logout);
        logoutItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
//                Toast.makeText(getBaseContext(),"OK",Toast.LENGTH_SHORT).show();
                confirmLogout();
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void confirmLogout(){
            Dialog dialog=new Dialog(this);
//        View view  = getActivity().getLayoutInflater().inflate(R.layout.dialog_custom, null);
            dialog.setContentView(R.layout.dialog_custom);

            Button btn_yes=(Button)dialog.findViewById(R.id.btn_yes);
            Button btn_no=(Button)dialog.findViewById(R.id.btn_no);
            TextView tv_dialog_title= dialog.findViewById(R.id.tv_dialog_title);
            TextView tv_dialog_content=dialog.findViewById(R.id.tv_dialog_content);
            tv_dialog_title.setText("X??c nh???n ????ng xu???t");
            tv_dialog_content.setText("B???n c?? ch???c mu???n ????ng xu???t ch???");
            btn_yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    finish();
                    Intent intent=new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                }
            });
            btn_no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();
    }

    private final MyReceiver mNetworkReceiver2 = new MyReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            boolean isnotConnected = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            if (isnotConnected) {
                if(!((InfoAcc) activity.getApplication()).getMode().equals("offline")){
                    Dialog dialog1 = new Dialog(activity);
//        View view  = getActivity().getLayoutInflater().inflate(R.layout.dialog_custom, null);
                    dialog1.setContentView(R.layout.dialog_custom);

                    Button btn_yes = (Button) dialog1.findViewById(R.id.btn_yes);
                    Button btn_no = (Button) dialog1.findViewById(R.id.btn_no);
                    TextView tv_dialog_title = dialog1.findViewById(R.id.tv_dialog_title);
                    TextView tv_dialog_content = dialog1.findViewById(R.id.tv_dialog_content);
                    tv_dialog_title.setText("X??c nh???n chuy???n h?????ng");
                    tv_dialog_content.setText("B???n ???? m???t k???t n???i m???ng, chuy???n qua ch??? ????? offline?");
                    btn_yes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog1.dismiss();
                            finish();
                            ((InfoAcc) activity.getApplication()).setMode("offline");
                            Intent intent = new Intent(MainActivity.this, Login.class);
                            startActivity(intent);
//                        Toast.makeText(context, "Internet Connected 2", Toast.LENGTH_LONG).show();
                        }
                    });
                    btn_no.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog1.dismiss();
                        }
                    });
                    dialog1.show();
                }
            } else {
                if(((InfoAcc) activity.getApplication()).getMode().equals("offline"))
                Toast.makeText(context, "???? online ????ng nh???p l???i ????? chuy???n ch??? ?????", Toast.LENGTH_LONG).show();
                ((InfoAcc) activity.getApplication()).setMode("online");
            }
        }
    };
    private void insertQues(){
//        INSERT ALL QS
        ApiService.apiservice.getAllQues("getAllQS").enqueue(new Callback<AllQues>() {
            @Override
            public void onResponse(Call<AllQues> call, Response<AllQues> response) {
//                    Toast.makeText(getContext(),"CALL API SUCCESS",Toast.LENGTH_SHORT).show();
                AllQues allQues = response.body();
                ArrayList<Question> arrayList = allQues.getAllQues();
                for(Question q:arrayList)
                 try{
                     dbHandler.addQuestion(q);
                }catch (Exception e){

                }

//                    Log.e("size",Integer.toString(arrayList.size()));
            }

            @Override
            public void onFailure(Call<AllQues> call, Throwable t) {
                Toast.makeText(getBaseContext(),"L???y danh s??ch c??u h???i th???t b???i",Toast.LENGTH_SHORT).show();
            }
        });
////        INSERT ALL TEST

    }
    private void insertTest(){
        ApiService.apiservice.getAllTestAndQS("getAllTestAndQS").enqueue(new Callback<AllTestQS>() {
            @Override
            public void onResponse(Call<AllTestQS> call, Response<AllTestQS> response) {
//                lv_test=(ListView)getActivity().findViewById(R.id.lv_test);
//                Toast.makeText(getContext(), "Call API SUCCESS", Toast.LENGTH_SHORT).show();
                AllTestQS alltest=response.body();
//                Toast.makeText(getBaseContext(), "l???y d??? li???u b??i thi th??nh c??ng 222", Toast.LENGTH_SHORT).show();
                ArrayList<TestQS> listTest = alltest.getAllTest();
//                testArrayList = new ArrayList<String>();
                int i=0;
                for(TestQS t : listTest)
                {
                    i++;
                    try{
                        dbHandler.addTest(t);
                    }catch (Exception e){

                    }

                }
                Log.e("Tong so",Integer.toString(i));

//                Toast.makeText(getContext(), "Call API get test 1 lan", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<AllTestQS> call, Throwable t) {
//                dialog2.dismiss();
                Toast.makeText(getBaseContext(), "l???y d??? li???u b??i thi th???t b???i 222", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mNetworkReceiver2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
//        mNetworkReceiver = new MyReceiver();
        this.registerReceiver(mNetworkReceiver2, filter);
    }
}