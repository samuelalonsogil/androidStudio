package com.example.fragmentcommunicationshakespeare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {


    public boolean dualPanel;
    public MasterFragment masterFragment;
    public DetailFragment detailFragment;
    public FrameLayout frameLayout;
    public FragmentTransaction fragmentTransaction;
    public Bundle bundle;

    public void sendCountryName(String countryName){
        if (dualPanel){
            /*dual panel*/
            detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.framelayoutDetail);
            detailFragment.showSelectedText(countryName);
        }else{
            /*single panel*/
            detailFragment = new DetailFragment();
            bundle = new Bundle();
            bundle.putString(DetailFragment.KEY_TITLE, countryName);
            detailFragment.setArguments(bundle);
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framelayout01, detailFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    public void initVariables(){
        frameLayout = findViewById(R.id.framelayout01);
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
        masterFragment.setOnMasterSelectedListener(new MasterFragment.OnMasterSelectedItem() {
            @Override
            public void onItemSelected(String countryName) {
                sendCountryName(countryName);
            }
        });
    }

    public void checkMasterFragment(){
        if (masterFragment==null) {
            masterFragment = new MasterFragment();
            fragmentTransaction.add(R.id.framelayout01, masterFragment, "MASTER");
        }
    }

    public void checkMasterFragmentById(){
        if (masterFragment==null) {
            masterFragment = new MasterFragment();
            fragmentTransaction.add(R.id.framelayoutMaster, masterFragment);
        }
    }

    public void checkDetailFragment(){
        if (detailFragment!=null) fragmentTransaction.remove(detailFragment);
    }

    public void checkDetailFragment02(){
        if (detailFragment==null) {
            detailFragment = new DetailFragment();
            fragmentTransaction.add(R.id.framelayoutDetail, detailFragment);
        }
    }

    public void startTransaction(){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        masterFragment = (MasterFragment) getSupportFragmentManager().findFragmentByTag("MASTER");
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.framelayoutDetail);

        checkMasterFragment();
        checkDetailFragment();

        fragmentTransaction.commit();


    }

    public void startTransaction02(){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        masterFragment = (MasterFragment) getSupportFragmentManager().findFragmentById(R.id.framelayoutMaster);
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.framelayoutDetail);

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