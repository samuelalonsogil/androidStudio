package com.example.obteniendoresultados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText editText01, editText02;
    public Button button01;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        button01.setOnClickListener(this);
        saveData();
    }

    public void initVariables(){
        editText01 = findViewById(R.id.editText01);
        editText02 = findViewById(R.id.editText02);
        button01 = findViewById(R.id.button01);
    }

    public void saveData(){
        String data01 = getIntent().getStringExtra("keyName");
        String data02 = getIntent().getStringExtra("keyName02");

        editText01.setText(data01);
        editText02.setText(data02);
    }


    @Override
    public void onClick(View v) {
        String data01 = editText01.getText().toString();
        String data02 = editText02.getText().toString();

        intent = new Intent(MainActivity.this, SegundaActividad.class);
        intent.putExtra("keyName" , data01);
        intent.putExtra("keyName02" , data02);
        startActivity(intent);

    }
}