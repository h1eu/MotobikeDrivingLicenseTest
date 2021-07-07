package com.example.mototest.View.Test;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mototest.Api.ApiService;
import com.example.mototest.MainActivity;
import com.example.mototest.Model.Question;
import com.example.mototest.Model.Test;
import com.example.mototest.R;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayoutTest extends AppCompatActivity{
    private TextView tvbackquestion,tvnextquestion,tvcurrentquestion,tvmaxquestion,toolbar_time,tv_toolbar_check;
    private ImageView toolbar_back;
    private ViewPager viewPager;
//    private List<Question> questionList;
    private ActionBar actionBar;
    private  Question question;
    private ArrayList<String> listans=new ArrayList<String>();
    ArrayList<Question> questionArrayList=new ArrayList<>();
    private int point=0;
    private int ttTime=1;
    private boolean isSubmit=false;
    ArrayList<String> listdadung=new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_test);
        actionBar= getSupportActionBar();
        String action="getTest";
        initUi();
//        questionArrayList = getQuestionList();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!=null)
            if(bundle.getString("Idtest").equals("random")){
                action="getTestRand";
            }

        if(bundle!=null)
        ApiService.apiservice.getTest(action,bundle.getString("Idtest")).enqueue(new Callback<Test>() {
            @Override
            public void onResponse(Call<Test> call, Response<Test> response) {
                Toast.makeText(LayoutTest.this,"Call API SUCCESS",Toast.LENGTH_SHORT).show();
                Test test = response.body();
                if(test!=null) {
                    Log.e("test:", Integer.toString(test.getIdtest()));
                    questionArrayList=test.getListquestion();
                    while (listans.size()<questionArrayList.size()){
                        listans.add("");
                    }
                    ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),
                            FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, questionArrayList);
                    viewPager.setAdapter(viewPagerAdapter);

                    tv_toolbar_check.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkanser(false);
                        }
                    });

                    tvcurrentquestion.setText("1");
                    tvmaxquestion.setText(String.valueOf(questionArrayList.size()));
                    viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                        }

                        @Override
                        public void onPageSelected(int position) {
                            tvcurrentquestion.setText(String.valueOf(position+1));
                            if(position==0)
                            {
                                tvbackquestion.setVisibility(View.GONE);
                                tvnextquestion.setVisibility(View.VISIBLE);
                            } else if(position == questionArrayList.size()-1){
                                tvbackquestion.setVisibility(View.VISIBLE);
                                tvnextquestion.setVisibility(View.GONE);
                            }
                            else {
                                tvbackquestion.setVisibility(View.VISIBLE);
                                tvnextquestion.setVisibility(View.VISIBLE);
                            }
                        }

                        @Override
                        public void onPageScrollStateChanged(int state) {

                        }
                    });

                    toolbar_back.setOnClickListener(new  View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            isSubmit=true;
                            Intent intent=new Intent(LayoutTest.this, MainActivity.class);
                            startActivity(intent);
//                Toast.makeText(LayoutTest.this,"lick thanh cong",Toast.LENGTH_SHORT).show();

                        }
                    });

                    tvbackquestion.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            viewPager.setCurrentItem(viewPager.getCurrentItem()-1 );
                        }
                    });

                    tvnextquestion.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            viewPager.setCurrentItem(viewPager.getCurrentItem()+1 );
                        }
                    });
                }
                countdowntime();
            }

            @Override
            public void onFailure(Call<Test> call, Throwable t) {
                Toast.makeText(LayoutTest.this,"Call API FAILED",Toast.LENGTH_SHORT).show();
            }
        });



    }
    private void countdowntime() {
        long duration = TimeUnit.MINUTES.toMillis(ttTime);

        CountDownTimer countDownTimer=new CountDownTimer(duration,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //chuyển đổi mili giây sang phút và giây khi tick
                 String sduation = String.format(Locale.ENGLISH, "%02d : %02d"
                        , TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))

                );
                toolbar_time.setText(sduation);
                if(isSubmit==true)
                    this.cancel();
            }
            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(),"hết thời gian",Toast.LENGTH_SHORT).show();
                if(isSubmit==false)
                {
                    checkanser(true);
                }


            }
        }.start();
    }




    private void initUi() {
        tvbackquestion=(TextView)findViewById(R.id.tv_back_quesion);
        tvnextquestion=(TextView)findViewById(R.id.tv_next_quesion);
        tvcurrentquestion=(TextView)findViewById(R.id.tv_current_question);
        tvmaxquestion=(TextView)findViewById(R.id.tv_max_quesion);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        toolbar_time=(TextView)findViewById(R.id.tv_toolbar_time);
        toolbar_back=(ImageView) findViewById(R.id.iv_toolbar_back);
        tv_toolbar_check=(TextView) findViewById(R.id.tv_toobar_check);




    }

    protected boolean getisSubmit(){
        return isSubmit;
    }
    protected void setAns(Integer stt,String ctl){
        if(stt-1<listans.size())
            listans.set(stt-1,ctl);
        else {
            while ((stt - 1) > listans.size()) {
                listans.add("");
            }
            listans.add(ctl);
        }
    }
    private void checkanser(boolean timeout) {


        Button btn_exit,btn_finish;


        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.check_question);
        dialog.setTitle("Danh sach câu trả lời");
        btn_exit=(Button)dialog.findViewById(R.id.btn_exit);
        btn_finish=(Button)dialog.findViewById(R.id.btn_finish);
//        TINH DIEM

//        tv_result.setText(Integer.toString(point));
            CheckAnserAdapter checkAnserAdapter = new CheckAnserAdapter(listans, listdadung, this);
            GridView gridView = (GridView) dialog.findViewById(R.id.grv_listquestion);
            gridView.setAdapter(checkAnserAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dialog.dismiss();
            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        if(isSubmit) btn_finish.setVisibility(View.GONE);
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Log.e("size listdadung",Integer.toString(listdadung.size()));

                Submit();
                dialog.dismiss();
            }
        });

        if(timeout){
            Submit();
            dialog.dismiss();
        }
        dialog.show();
    }

    protected String getResult(int i){
        return questionArrayList.get(i).getDadung();
    }

    private void Submit(){
        for(int i=0;i<listans.size();i++){
            if (listans.get(i).equals(questionArrayList.get(i).getDadung()))
            {
                point+=1;
            }
            listdadung.add(questionArrayList.get(i).getDadung());
        }
        String[] DoTime=((String) toolbar_time.getText()).split(":");
        int minutes=Integer.parseInt(DoTime[0].trim());
        int seconds=Integer.parseInt(DoTime[1].trim());
        int timelambai=ttTime*60-minutes*60-seconds;
        String Dominutes=Integer.toString(timelambai/60);
        String Doseconds=Integer.toString(timelambai%60);
        Bundle bundle=new Bundle();
        bundle.putInt("point", point);
        bundle.putString("minutes",Dominutes);
        bundle.putString("seconds",Doseconds);
        isSubmit=true;
        Intent intent=new Intent(LayoutTest.this,Result.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    @Override
    protected void onStop() {
        super.onStop();
        isSubmit=true;
    }
}
