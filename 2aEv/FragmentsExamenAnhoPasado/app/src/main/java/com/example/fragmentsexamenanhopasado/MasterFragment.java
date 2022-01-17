package com.example.fragmentsexamenanhopasado;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class MasterFragment extends ListFragment {
    public ListAdapter listAdapter;

    /*crear interfaz*/
    public interface OnMasterSelectedListener{ void onItemSelected(String titulo); }

    public OnMasterSelectedListener selectorMaster;

    /*pasar la interfaz y asignarla*/
    public void setOnMasterSelectedListener(OnMasterSelectedListener listener){
        selectorMaster = listener;
    }

    /*crear vista y dar soporte a lainterfaz*/
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listAdapter = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_list_item_1, Textos.TITLES);
        setListAdapter(listAdapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        getListView().setOnItemClickListener((adapterView, view1, i, l) -> {
            if ( selectorMaster != null )
                selectorMaster.onItemSelected( (Textos.DIALOGUE[i]) );
        });
    }
}
