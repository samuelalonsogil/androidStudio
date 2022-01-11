package com.example.calculadora;

import static com.example.calculadora.MainActivity.EXTRA_ENTERO;
import static com.example.calculadora.MainActivity.EXTRA_ENTERO2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_CADENA = "EXTRA_CADENA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        extraerDatos(intent);
    }

    public void extraerDatos(Intent intent){
        //recuperar el intent

        String returnedInteger = intent.getStringExtra(EXTRA_ENTERO);
        String returnedInteger02 = intent.getStringExtra(EXTRA_ENTERO2);

        //extraer los enteros

        EditText editText = findViewById(R.id.editTextNumber01);
        EditText editText02 = findViewById(R.id.editTextNumber02);

        //colocarlos en los editTexts

        editText.setText(returnedInteger);
        editText02.setText(returnedInteger02);
    }

    public void calcular(View view){
        EditText editText01 = findViewById(R.id.editTextNumberSigned01);
        EditText editText02 = findViewById(R.id.editTextNumberSigned02);

        Integer number01 = Integer.parseInt(editText01.getText().toString());
        Integer number02 = Integer.parseInt(editText02.getText().toString());

        Integer resultado = null;
        TextView result = findViewById(R.id.textView2);

        Button b = (Button)view;
        int entBoton = b.getId();


        if(entBoton == R.id.buttonMultiplicar){
            Toast.makeText(this, "Pulsaste multiplicar", Toast.LENGTH_LONG).show();
            resultado = number01 * number02;
            result.setText(String.valueOf(resultado));
        }else if(entBoton == R.id.buttonDividir){
            Toast.makeText(this, "Pulsaste dividir", Toast.LENGTH_LONG).show();
            resultado = number01 / number02;
            result.setText(String.valueOf(resultado));
        }



    }

    public void regresarALaPrimera(View view){
        TextView textView = findViewById(R.id.textView2);
        String m = textView.getText().toString();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_CADENA, m);

        startActivity(intent);

        Toast.makeText(this, "MANDANDO_RESULTADO", Toast.LENGTH_SHORT).show();
    }
}