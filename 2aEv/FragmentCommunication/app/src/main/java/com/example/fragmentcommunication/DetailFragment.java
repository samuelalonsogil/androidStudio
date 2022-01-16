package com.example.fragmentcommunication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {
    public static String KEY_COUNTRY_NAME= "KEY_COUNTRY_NAME";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null && bundle.containsKey(KEY_COUNTRY_NAME) ) showSelectedCountry(bundle.getString(KEY_COUNTRY_NAME));
    }

    public void showSelectedCountry(String countryName) {
        ( (TextView)getView().findViewById(R.id.textView01) ).setText(countryName);
    }
}
