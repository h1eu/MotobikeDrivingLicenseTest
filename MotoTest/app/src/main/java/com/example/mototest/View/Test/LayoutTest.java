package com.example.mototest.View.Test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mototest.MainActivity;
import com.example.mototest.Models.Test;
import com.example.mototest.R;

import java.util.ArrayList;
import java.util.List;

public class LayoutTest extends AppCompatActivity{
    private TextView tvbackquestion,tvnextquestion,tvcurrentquestion,tvmaxquestion,toolbar_title ;
    private ImageView toolbar_back;
    private ViewPager viewPager;
    private List<Test> testList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_test);

        initUi();
        testList = getQuestionList();
         ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),
                 FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, testList);
         viewPager.setAdapter(viewPagerAdapter);

         tvcurrentquestion.setText("1");
         tvmaxquestion.setText(String.valueOf(testList.size()));

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
                 } else if(position == testList.size()-1){
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
         toolbar_title.setText("Đề Thi");
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

        toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(LayoutTest.this, MainActivity.class);
//                startActivity(intent);
                Toast.makeText(LayoutTest.this,"lick thanh cong",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initUi() {
        tvbackquestion=(TextView)findViewById(R.id.tv_back_quesion);
        tvnextquestion=(TextView)findViewById(R.id.tv_next_quesion);
        tvcurrentquestion=(TextView)findViewById(R.id.tv_current_question);
        tvmaxquestion=(TextView)findViewById(R.id.tv_max_quesion);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        toolbar_title=(TextView)findViewById(R.id.tv_toolbar_title);
        toolbar_back=(ImageView) findViewById(R.id.iv_toolbar_back);

    }
    private List<Test> getQuestionList(){
        List<Test> list=new ArrayList<>();
        for (int i=1;i<=20;i++){
            list.add(new Test("question"+i));
        }
        return list;
    }

}
