package com.example.mototest.View.Test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mototest.MainActivity;
import com.example.mototest.Model.Question;
import com.example.mototest.Model.Test;
import com.example.mototest.R;

import java.util.ArrayList;
import java.util.List;

public class LayoutTest extends AppCompatActivity{
    private TextView tvbackquestion,tvnextquestion,tvcurrentquestion,tvmaxquestion,toolbar_title ;
    private ImageView toolbar_back;
    private ViewPager viewPager;
    private List<Question> testList;
    private ListView listquestion;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_test);

        initUi();
        testList = getQuestionList();

        CustomAdapter customAdapter=new CustomAdapter(getBaseContext(),R.layout.fragment_layout_test,testList);
        listquestion.setAdapter(customAdapter);

        toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LayoutTest.this,"lick thanh cong",Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void initUi() {
//        viewPager=(ViewPager) findViewById(R.id.viewpager);
        listquestion = (ListView) findViewById(R.id.listquestion);
        toolbar_title=(TextView) findViewById(R.id.tv_toolbar_title);
        toolbar_back=(ImageView) findViewById(R.id.iv_toolbar_back);


    }
    private List<Question> getQuestionList(){
        List<Question> list=new ArrayList<>();
        for (int i=1;i<=20;i++){
            list.add(new Question(i,"a","3","4","3","23","3","4","3"));
        }
        return list;
    }

}
