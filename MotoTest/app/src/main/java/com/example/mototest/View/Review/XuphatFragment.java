package com.example.mototest.View.Review;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mototest.Api.ApiService;
import com.example.mototest.Model.ContentPost;
import com.example.mototest.Model.Post;
import com.example.mototest.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class XuphatFragment extends Fragment {
    ArrayList<ContentPost> contentPostArrayList=new ArrayList<>();
    Context context;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_xuphat, container, false);
        listView=(ListView)v.findViewById(R.id.lv_mucxuphat);
        callapi();
        context=container.getContext();
        // Inflate the layout for this fragment
        return v;
    }

    private void callapi() {
        ApiService.apiservice2.getXuphat("getXuphat").enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post post=response.body();
                contentPostArrayList=post.getMucXP();
                ReviewAdapter reviewAdapter=new ReviewAdapter(context,contentPostArrayList);
                listView.setAdapter(reviewAdapter);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("loi","call false");
            }
        });
    }
}