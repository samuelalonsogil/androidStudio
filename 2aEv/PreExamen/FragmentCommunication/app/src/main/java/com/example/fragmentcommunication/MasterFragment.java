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

    public ListAdapter countryAdapter;

    public interface OnMasterSelectedListener{
        public void onItemSelected(String countryName);
    }

    /*interface callback listener*/
    private OnMasterSelectedListener onMasterSelectedListener = null;
    public void setOnMasterSelectedListener(OnMasterSelectedListener listener){
        onMasterSelectedListener = listener;
    }

    /*create listAdapter to populate listView*/

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String [] countries = { "China", "France", "Germany", "India", "Russia", "UK", "USA" };
        countryAdapter = new ArrayAdapter<String>( getActivity(), android.R.layout.simple_list_item_1, countries );
        setListAdapter(countryAdapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (onMasterSelectedListener!=null){
                    onMasterSelectedListener.onItemSelected( ( (TextView) view ).getText().toString() );
                }
            }
        });
    }
}
