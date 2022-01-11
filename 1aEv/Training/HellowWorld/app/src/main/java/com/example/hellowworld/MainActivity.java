package com.example.hellowworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //acceder al activity main
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        //R gives access to all the resources in the poject
        TextView textView01 = findViewById(R.id.textView);
        EditText editText01 = findViewById(R.id.editText01);

        //change the text of the textView
        textView01.setText("Hello " + editText01.getText().toString());


    }
}