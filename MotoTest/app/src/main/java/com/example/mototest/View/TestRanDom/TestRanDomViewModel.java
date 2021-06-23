package com.example.mototest.View.TestRanDom;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TestRanDomViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TestRanDomViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Thi Ngẫu Nhiên");
    }

    public LiveData<String> getText() {
        return mText;
    }
}