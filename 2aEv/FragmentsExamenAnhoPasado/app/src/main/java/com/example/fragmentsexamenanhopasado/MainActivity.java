package com.example.fragmentsexamenanhopasado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity{

    boolean dualPanel;
    MasterFragment masterFragment;
    DetailFragment detailFragment;
    Bundle bundle;
    FragmentTransaction fragmentTransaction;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        fragmentMode();
    }

    public void fragmentMode(){
        if (frameLayout != null){
            dualPanel = false;

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            masterFragment = (MasterFragment) getSupportFragmentManager().findFragmentByTag("MASTER");

            if (masterFragment == null){
                masterFragment = new MasterFragment();
                fragmentTransaction.add(R.id.frameLayoutPortrait, masterFragment, "MASTER");
            }

            detailFragment = (DetailFragment)
                    getSupportFragmentManager().findFragmentById(R.id.frameLayoutDetail);

            if (detailFragment != null) fragmentTransaction.remove(detailFragment);

        }else{
            dualPanel = true;

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            masterFragment = (MasterFragment)
                    getSupportFragmentManager().findFragmentById(R.id.frameLayoutMaster);

            if (masterFragment == null){
                masterFragment = new MasterFragment();
                fragmentTransaction.add(R.id.frameLayoutMaster, masterFragment);
            }

            detailFragment = (DetailFragment)
                    getSupportFragmentManager().findFragmentById(R.id.frameLayoutDetail);

            if (detailFragment == null) {
                detailFragment = new DetailFragment();
                fragmentTransaction.add(R.id.frameLayoutDetail, detailFragment);
            }

        }
        fragmentTransaction.commit();

        masterFragment.setOnMasterSelectedListener(new MasterFragment.OnMasterSelectedListener() {
            @Override
            public void onItemSelected(String texto) {
                sendText( (texto)  );
            }
        });
    }

    public void sendText(String texto){
        /*si está en modo landscape, el texto se pone en el framelayout del lado*/
        if (dualPanel) {
            detailFragment = (DetailFragment)
                    getSupportFragmentManager().findFragmentById( R.id.frameLayoutDetail );

            if( detailFragment != null) detailFragment.showSelectText(texto);
        }

        /*si está en modo portrait, el texto se superpone a la lista*/
        else{

            detailFragment = new DetailFragment();
            bundle = new Bundle();

            bundle.putString(DetailFragment.KEY_TITLE,texto);
            detailFragment.setArguments( bundle );

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayoutPortrait, detailFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    public void initVariables(){
        detailFragment = new DetailFragment();
        bundle = new Bundle();
        masterFragment = new MasterFragment();
        frameLayout = findViewById(R.id.frameLayoutPortrait);
    }

}