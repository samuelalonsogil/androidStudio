package com.example.ejercicio01aexamen1aev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText editText01, editText02, editText03;
    public Button button01, button02, button03;
    public Intent intent02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initVariables();
        saveData();
        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button03.setOnClickListener(this);

    }

    public void initVariables(){
        editText01 = findViewById(R.id.editTextNum01);
        editText02 = findViewById(R.id.editTextNum02);
        editText03 = findViewById(R.id.editTextResult);

        button01 = findViewById(R.id.buttonMultiply);
        button02 = findViewById(R.id.buttonDivide);
        button03 = findViewById(R.id.buttonToActivity1);
    }

    public void saveData(){
        String num01 = getIntent().getStringExtra("key01");
        String num02 = getIntent().getStringExtra("key02");

        editText01.setText(num01);
        editText02.setText(num02);
    }

    @Override
    public void onClick(View v) {
        double number01 = Double.parseDouble( editText01.getText().toString() );
        double number02 = Double.parseDouble( editText02.getText().toString() );

        if ( v.getId() == button01.getId() ) editText03.setText(String.valueOf(number01 * number02));

        else if( v.getId() == button02.getId() ) editText03.setText(String.valueOf(number01 / number02));

        else if( v.getId() == button03.getId() ) {
            intent02 = new Intent(SecondActivity.this , MainActivity.class);
            intent02.putExtra("key1" , editText03.getText().toString() );
            intent02.putExtra("key2" , editText01.getText().toString() );
            intent02.putExtra("key3" , editText02.getText().toString() );
            startActivity(intent02);
        }
    }
}