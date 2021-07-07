package com.example.mototest.View.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mototest.R;
import com.squareup.picasso.Picasso;

public class Result extends AppCompatActivity {
    private Button btn_xemlaibaithi;
    private TextView tv_diem,tv_ketqua;
    private LinearLayout ll_rs;
    private ImageView img_v1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        btn_xemlaibaithi=(Button)findViewById(R.id.btn_xemlaibaithi) ;
        tv_diem=(TextView)findViewById(R.id.tv_diem);
        tv_ketqua=(TextView)findViewById(R.id.tv_ketqua);
//        ActionBar actionBar=getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setTitle("Kết quả thi");
//        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getApplicationContext(), R.color.orange)));
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!=null) {
            tv_diem.setText(Integer.toString(bundle.getInt("point")));
            if(bundle.getInt("point")>15)
                tv_ketqua.setText("ĐỖ - Time: "+bundle.get("minutes")+":"+bundle.get("seconds"));
            else
                tv_ketqua.setText("Trượt - Time: "+bundle.get("minutes")+":"+bundle.get("seconds"));

//            ***************************************************************
            ll_rs=findViewById(R.id.ll_rs);
            createImg("https://i.imgur.com/DvpvklR.png");


        }
        btn_xemlaibaithi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void createImg(String url){
        ImageView imageView = new ImageView(this);
        Picasso.get().load(url).into(imageView);
        ll_rs.addView(imageView);
    }
}