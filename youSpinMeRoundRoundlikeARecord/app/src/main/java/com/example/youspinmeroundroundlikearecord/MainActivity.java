package com.example.youspinmeroundroundlikearecord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Nombres> listaCiudades;
    public Spinner sp ;
    public TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        sp = (Spinner) findViewById(R.id.spinner);
        listaCiudades = new ArrayList<Nombres>();
        llenar();

        personSpinnerAdapter adapter = new personSpinnerAdapter(this, R.layout.linea, listaCiudades);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv.setText("Has pulsado: " + listaCiudades.get(position).getNombre());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tv.setText("");
            }
        });

    }

    private void llenar() {
        listaCiudades.add(new Nombres("Albacete", "Albacete desc", R.drawable.albacete));
        listaCiudades.add(new Nombres("Ciudad Real", "Ciudad des", R.drawable.ciudadreal));
        listaCiudades.add(new Nombres("Cuenca", "Cuenca desc", R.drawable.cuenca));
        listaCiudades.add(new Nombres("Guadalajara", "Guadalajara desc", R.drawable.guadalajara));
        listaCiudades.add(new Nombres("Toledo", "Toledo desc", R.drawable.toledo));
    }

}