package com.example.mototest.View.Test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mototest.Model.Question;
import com.example.mototest.Model.Test;
import com.example.mototest.Model.Test;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<Question> testList;
    public ViewPagerAdapter(@NonNull @NotNull FragmentManager fm, int behavior,List<Question> list) {
        super(fm, behavior);
        this.testList =list;
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        if(testList ==null || testList.isEmpty()){
            return null;
        }
        else
        {
            Question question = testList.get(position);
            LayoutTestFragment questionFragment=new LayoutTestFragment();
            Bundle bundle=new Bundle();
            bundle.putSerializable("idquestion", (Serializable) question);
            questionFragment.setArguments(bundle);
            return  questionFragment;
        }
    }

    @Override
    public int getCount() {
        if(testList !=null){
            return testList.size();
        }
        return 0;
    }
}
