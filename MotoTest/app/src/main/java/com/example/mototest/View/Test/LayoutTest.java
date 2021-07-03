package com.example.mototest.View.Test;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mototest.MainActivity;
import com.example.mototest.Model.Question;
import com.example.mototest.Model.Test;
import com.example.mototest.Model.Test;
import com.example.mototest.R;
import com.example.mototest.View.Result;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class LayoutTest extends AppCompatActivity{
    private TextView tvbackquestion,tvnextquestion,tvcurrentquestion,tvmaxquestion,toolbar_title,tv_toolbar_check ;
    private ImageView toolbar_back;
    private ViewPager viewPager;
    private List<Question> questionList;
    private ActionBar actionBar;
    private  Question question;
    ArrayList<Question> arrayListanser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_test);
        actionBar= getSupportActionBar();
        initUi();
        questionList = getQuestionList();

          ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),
                 FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, questionList);
         viewPager.setAdapter(viewPagerAdapter);

         tvcurrentquestion.setText("1");
         tvmaxquestion.setText(String.valueOf(questionList.size()));
         toolbar_title.setText("Đề Thi");
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
                 } else if(position == questionList.size()-1){
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
        tv_toolbar_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkanser();
            }
        });



    }

    private void checkanser() {
        Button btn_exit,btn_finish;
        btn_exit=(Button)findViewById(R.id.btn_exit);
        btn_finish=(Button)findViewById(R.id.btn_finish);
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.check_question);
        dialog.setTitle("Danh sach câu trả lời");

        CheckAnserAdapter checkAnserAdapter=new CheckAnserAdapter(arrayListanser,this);
        GridView gridView=(GridView) findViewById(R.id.grv_listquestion);
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
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.show();


    }

    private void initUi() {
        tvbackquestion=(TextView)findViewById(R.id.tv_back_quesion);
        tvnextquestion=(TextView)findViewById(R.id.tv_next_quesion);
        tvcurrentquestion=(TextView)findViewById(R.id.tv_current_question);
        tvmaxquestion=(TextView)findViewById(R.id.tv_max_quesion);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        toolbar_title=(TextView)findViewById(R.id.tv_toolbar_title);
        toolbar_back=(ImageView) findViewById(R.id.iv_toolbar_back);
        tv_toolbar_check=(TextView) findViewById(R.id.tv_toobar_check);




    }
    private List<Question> getQuestionList(){
        List<Question> list=new ArrayList<>();
        for (int i=1;i<=20;i++){
            list.add(new Question(2,"3","asd","asd","1","ads","asd","asd","1",""));
        }
        return list;
    }

}
