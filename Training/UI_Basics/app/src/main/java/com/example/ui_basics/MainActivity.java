package com.example.ui_basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //start of the app
        setContentView(R.layout.activity_main);
    }


    //when the button is clicked  the text is gonna change
    public void onHelloButtonClick(View view) {

        TextView textView01 = findViewById(R.id.textView01);
        textView01.setText("Hello again!");
    }
}