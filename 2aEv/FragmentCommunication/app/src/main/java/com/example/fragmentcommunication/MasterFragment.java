package com.example.fragmentcommunication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class MasterFragment extends ListFragment {
    public ListAdapter listAdapter;
    private OnMasterSelectedListener masterSelectedListener;

    /*PREPARAMOS UNA INTERFAZ PARA PASAR INFO*/
    public interface OnMasterSelectedListener{
        public void OnItemSelected(String countryName);
    }

    /*PASAMOS LA INTERFAZ Y LA ASIGNAMOS LA DECLARADA A ESTA CLASE*/
    public void setOnMasterSelectedListener(OnMasterSelectedListener listener){
        masterSelectedListener = listener;
    }

    /*CREAMOS LA VISTA Y DAMOS SOPORTE AL METODO DE LA INTERFAZ*/
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*PREPARAMOS LOS DATOS*/
        String[] countries = { "China", "Francia", "España", "India", "Rusia", "UK" };
        listAdapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, countries );

        setListAdapter(listAdapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (masterSelectedListener != null) {
                    masterSelectedListener.OnItemSelected( ((TextView) view ).getText().toString() );
                }
            }
        });
    }


}
