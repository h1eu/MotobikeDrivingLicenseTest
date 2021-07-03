package com.example.mototest.View.ChangePass;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mototest.R;
import com.example.mototest.View.Login;
import com.example.mototest.View.Test.LayoutTest;

import org.jetbrains.annotations.NotNull;


public class ChangepassFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_changepass, container, false);
        // Inflate the layout for this fragment
        return v;
    }

}