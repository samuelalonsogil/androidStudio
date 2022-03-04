package com.example.ejercicio01;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class MasterFragment extends ListFragment {
    public ListAdapter titleList;
    public interface OnMasterSelectedItem{
        void onItemSelected(String title);
    }
    public OnMasterSelectedItem selectorMaster;
    public void setOnMasterSelectedListener(OnMasterSelectedItem onMasterSelectedListener){
        selectorMaster = onMasterSelectedListener;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        titleList = new ArrayAdapter<>( getActivity(), android.R.layout.simple_list_item_1,  );
        setListAdapter(titleList);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (selectorMaster != null) selectorMaster.onItemSelected(  );
            }
        });
    }
}
