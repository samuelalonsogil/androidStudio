package com.example.fragmentcommunicationshakespeare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {
    public static final String KEY_TITLE = "KEY_TITLE";
    public Bundle bundle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bundle = getArguments();
        if (bundle!=null && bundle.containsKey(KEY_TITLE) ) showSelectedText( bundle.getString(KEY_TITLE) );
    }

    public void showSelectedText(String text) {
        ( (TextView) requireView().findViewById(R.id.textView01) ).setText( text );
    }
}
