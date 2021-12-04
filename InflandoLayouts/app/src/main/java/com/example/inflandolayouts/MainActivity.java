package com.example.inflandolayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void izquierda(View view) {
        setContentView(R.layout.activity_main_02);
        Toast.makeText(this, "Vista izquierda" ,Toast.LENGTH_LONG).show();
    }

    public void derecha(View view) {
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Vista derecha" ,Toast.LENGTH_LONG).show();
    }

    //cerrar la app
    public void terminar(View view) {
        finish();
    }

    
    public void IrTerminar(View view) {
        //tb puedo cargar una vista por su id
        findViewById(R.id.terminar);

        setContentView(R.layout.activity_main_final);

    }


}