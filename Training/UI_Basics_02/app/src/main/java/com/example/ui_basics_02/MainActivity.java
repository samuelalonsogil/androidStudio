package com.example.ui_basics_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

                                                    //best OnClick method
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //instanciarlos fuera para poder usarlos en todos los métodos
    private EditText editText01;
    private TextView textView01;

    @Override
    public void onClick(View v) {
        switch (v.getId() ){
            case R.id.button01:
                                                                //how long is the msg shown
                Toast.makeText(this, "Hello there!", Toast.LENGTH_SHORT).show();

                textView01.setText("Hello " + editText01.getText().toString());

                break;
            case R.id.editTextName:
                Toast.makeText(this, "Go ahead, type", Toast.LENGTH_SHORT).show();

            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button01 = findViewById(R.id.button01);

        //best onClick method alternative
        button01.setOnClickListener(this); //le pasas la clase que tiene la interfaz con el metodo

        button01.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                            //aqui te pilla la interfaz con el this
                Toast.makeText(MainActivity.this, "Too long!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        editText01 = findViewById(R.id.editTextName);
        editText01.setOnClickListener(this); //le pasas la clase que tiene la interfaz con el metodo

        textView01 = findViewById(R.id.textView01);


    }
}