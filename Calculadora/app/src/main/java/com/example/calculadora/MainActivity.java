package com.example.calculadora;

import static com.example.calculadora.SecondActivity.EXTRA_CADENA;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_ENTERO = "EXTRA_ENTERO";
    public static final String EXTRA_ENTERO2 = "EXTRA_ENTERO_2";


    EditText editText01 = null;
    EditText editText02 = null;

    //usamos dos variables globales para no perder los numeros originales añ operar
    Integer number01;
    Integer number02;
    public static final String NUMBER01 = "NUMBER01";
    public static final String NUMBER02 = "NUMBER02";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        mostrarResultado(intent);
    }
    

    public void mandarDatos(View view){

        //preparar un intent
        Intent intent = new Intent(this, SecondActivity.class);

        //meter dos enteros
        editText01 = findViewById(R.id.editTextNumber01);
        editText02 = findViewById(R.id.editTextNumber02);

        number01 = Integer.parseInt(editText01.getText().toString());
        number02 = Integer.parseInt(editText02.getText().toString());

        intent.putExtra(EXTRA_ENTERO, editText01.getText().toString());
        intent.putExtra(EXTRA_ENTERO2, editText02.getText().toString());

        //start la segunda
        startActivity(intent);
    }

    private void mostrarResultado(Intent intent) {
        //recuperar el intent
        //recuperar los enteros
        //colocarlos en los editText

        Toast.makeText(this, "MOSTRAR RESULTADO", Toast.LENGTH_LONG).show();
        String returnedCadena = intent.getStringExtra(EXTRA_CADENA);

        TextView textView = findViewById(R.id.textView2);

        editText01 = findViewById(R.id.editTextNumberSigned01);
        editText02 = findViewById(R.id.editTextNumberSigned02);

        textView.setText(returnedCadena);

        editText01.setText(Integer.toString(number01));
        editText02.setText(Integer.toString(number02));

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //guardamos la info que nos interese

        EditText editText01 = findViewById(R.id.editTextNumberSigned01);
        EditText editText02 = findViewById(R.id.editTextNumberSigned02);

        number01 = Integer.parseInt(editText01.getText().toString());
        number02 = Integer.parseInt( editText02.getText().toString()   );

        outState.putInt(NUMBER01, number01);
        outState.putInt(NUMBER02,number02);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //recuperamos la info guardada

        EditText editText01 = findViewById(R.id.editTextNumberSigned01);
        EditText editText02 = findViewById(R.id.editTextNumberSigned02);

        number01 = savedInstanceState.getInt(NUMBER01);
        number02 = savedInstanceState.getInt(NUMBER02);

        editText01.setText(Integer.toString(number01));
        editText02.setText(Integer.toString(number02));
    }
}