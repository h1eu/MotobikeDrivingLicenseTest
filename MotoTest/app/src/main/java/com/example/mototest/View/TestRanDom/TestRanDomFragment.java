package com.example.mototest.View.TestRanDom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mototest.databinding.FragmentTestrandomBinding;

public class TestRanDomFragment extends Fragment {

    private TestRanDomViewModel testrandomViewModel;
    private FragmentTestrandomBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        testrandomViewModel =
                new ViewModelProvider(this).get(TestRanDomViewModel.class);

        binding = FragmentTestrandomBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textTestrandom;
        testrandomViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}