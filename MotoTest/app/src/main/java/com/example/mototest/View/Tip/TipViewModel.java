package com.example.mototest.View.Tip;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TipViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TipViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Mẹo Thi");
    }

    public LiveData<String> getText() {
        return mText;
    }
}