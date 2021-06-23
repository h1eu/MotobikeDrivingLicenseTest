package com.example.mototest.View.Review;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReviewViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ReviewViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ôn Tập lý thuyết");
    }

    public LiveData<String> getText() {
        return mText;
    }
}