package com.example.downloadimagelibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button button;
    ImageView imageView;



    public void initVariables(){
        editText = findViewById(R.id.editTextURL);
        button = findViewById(R.id.button01);
        button.setOnClickListener(this);
        imageView = findViewById(R.id.imageView01);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();

    }

    @Override
    public void onClick(View view) {
        Glide.with(MainActivity.this).load( editText.getText().toString() ).into(imageView);

    }
}