package com.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_child, container, false);
        return view;
    }

    public void refrech(String title, String newsContent) {
        View visibilityLayoult = view.findViewById(R.id.visibility_layout);
        visibilityLayoult.setVisibility(View.VISIBLE);
        TextView titleText = ( TextView ) view.findViewById(R.id.news_title);
        TextView newsContentText = ( TextView ) view.findViewById(R.id.news_content);
        titleText.setText(title);
        newsContentText.setText(newsContent);
    }

}
