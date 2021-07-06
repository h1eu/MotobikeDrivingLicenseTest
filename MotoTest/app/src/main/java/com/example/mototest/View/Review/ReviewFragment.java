package com.example.mototest.View.Review;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mototest.R;


public class ReviewFragment extends Fragment {
    private WebView wv_onlt;
    private View v;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_review, container, false);
        wv_onlt=v.findViewById(R.id.wv_onlt);
        final String descriptionUsingWebView = "<h2>Display HTML code in Android using WebView</h2><img alt=\"Create Project display HTML code in Android Studio\" border=\"0\" data-original-height=\"200\" data-original-width=\"200\" height=\"200\" src=\"https://4.bp.blogspot.com/-OKH-ymCPRLs/WqaRezWliHI/AAAAAAAAAUI/ixdFOFnnzy8qlBbHzoGSirf6l9-TnM9tgCLcBGAs/s640/select%2Bthe%2BActivity.jpg\" title=\"Create Project display HTML code in Android Studio\" width=\"200\">";
        wv_onlt.loadDataWithBaseURL(null, descriptionUsingWebView, "text/html", "utf-8", null);
        return v;
    }
}