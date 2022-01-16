package com.example.fragmentsexamenanhopasado;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class DetailFragment extends Fragment {
    public static String KEY_TITLE = "key_title";
    Bundle bundle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate( R.layout.detail_fragment, container, false );
    }

    public void showSelectText(String texto){
        ( (TextView) requireView().findViewById(R.id.muchoTexto) ).setText(texto);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bundle = getArguments();
        if ( bundle != null && bundle.containsKey( KEY_TITLE ) )
            showSelectText( bundle.getString( KEY_TITLE ) ) ;
    }
}
