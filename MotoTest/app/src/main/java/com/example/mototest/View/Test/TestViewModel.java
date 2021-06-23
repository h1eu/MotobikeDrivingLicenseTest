package com.example.mototest.View.Test;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TestViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TestViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Thi theo đề");
    }

    public LiveData<String> getText() {
        return mText;
    }
}