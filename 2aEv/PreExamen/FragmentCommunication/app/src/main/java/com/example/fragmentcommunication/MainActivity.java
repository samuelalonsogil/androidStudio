package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity{

    public boolean dualPanel;
    public MasterFragment masterFragment;
    public DetailFragment detailFragment;
    public FrameLayout frameLayout;
    public FragmentTransaction fragmentTransaction;
    public Bundle bundle;

    public void sendCountryName(String countryName){
        if (dualPanel){
            /*dual panel*/
            detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frameLayoutDetail);
            detailFragment.showSelectedCountry(countryName);
        }else{
            /*single panel*/
            detailFragment = new DetailFragment();
            bundle = new Bundle();
            bundle.putString(DetailFragment.KEY_NAME, countryName);
            detailFragment.setArguments(bundle);
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout01, detailFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    public void initVariables(){
        frameLayout = findViewById(R.id.frameLayout01);
    }

    public void checkDualPanel(){
        if (frameLayout!=null) {
            dualPanel = false;
            startTransaction();
        }
        else {
            dualPanel = true;
            startTransaction02();
        }
        masterFragment.setOnMasterSelectedListener(new MasterFragment.OnMasterSelectedListener() {
            @Override
            public void onItemSelected(String countryName) {
                sendCountryName(countryName);
            }
        });
    }

    public void checkMasterFragment(){
        if (masterFragment==null) {
            masterFragment = new MasterFragment();
            fragmentTransaction.add(R.id.frameLayout01, masterFragment, "MASTER");
        }
    }

    public void checkMasterFragmentById(){
        if (masterFragment==null) {
            masterFragment = new MasterFragment();
            fragmentTransaction.add(R.id.frameLayoutMaster, masterFragment);
        }
    }

    public void checkDetailFragment(){
        if (detailFragment!=null) fragmentTransaction.remove(detailFragment);
    }

    public void checkDetailFragment02(){
        if (detailFragment==null) {
            detailFragment = new DetailFragment();
            fragmentTransaction.add(R.id.frameLayoutDetail, detailFragment);
        }
    }

    public void startTransaction(){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        masterFragment = (MasterFragment) getSupportFragmentManager().findFragmentByTag("MASTER");
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frameLayoutDetail);

        checkMasterFragment();
        checkDetailFragment();

        fragmentTransaction.commit();


    }

    public void startTransaction02(){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        masterFragment = (MasterFragment) getSupportFragmentManager().findFragmentById(R.id.frameLayoutMaster);
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frameLayoutDetail);

        checkMasterFragmentById();
        checkDetailFragment02();

        fragmentTransaction.commit();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        checkDualPanel();

    }


}