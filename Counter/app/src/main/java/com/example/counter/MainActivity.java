package com.example.counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String KEY_COUNTER = "CONTADOR";
    private int miContador=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //info de preferencias
        SharedPreferences settings = getPreferences(MODE_PRIVATE);
        int defaultCounter = 0;

        //recuperar la info guardada
        miContador = settings.getInt(KEY_COUNTER, defaultCounter);

        ((TextView)findViewById(R.id.textViewCounter)).setText("Contador: " + Integer.toString(miContador));

    }

    public void onClicContador(View view) {
        miContador++;
        ((TextView)findViewById(R.id.textViewCounter))
                .setText("Contador: " + Integer.toString(miContador));
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //guardamos la info que nos interese
        outState.putInt(KEY_COUNTER, miContador);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //recuperamos la info guardada
        miContador=savedInstanceState.getInt(KEY_COUNTER);


    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences settings = getPreferences(MODE_PRIVATE);

        //instanciar editor para manipular las preferencias que quieras
        SharedPreferences.Editor editor = settings.edit();

        //similar a onSave
        editor.putInt(KEY_COUNTER, miContador);

        //no olvidar el commit, la ejecucion
        editor.commit();
    }

}