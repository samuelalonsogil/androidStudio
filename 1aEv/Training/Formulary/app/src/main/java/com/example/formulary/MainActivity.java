package com.example.formulary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void introuceTheUser(View view) {
        EditText editText01 = findViewById(R.id.editTextName);
        EditText editText02 = findViewById(R.id.editTextLastName);
        EditText editText03 = findViewById(R.id.editTextEmail);

        TextView textView01 = findViewById(R.id.textViewName);
        TextView textView02 = findViewById(R.id.textViewLastName);
        TextView textView03 = findViewById(R.id.textViewEmail);

        //put the text introduced on the textViews
        textView01.setText("First name: " + editText01.getText().toString());
        textView02.setText("Last name: " + editText02.getText().toString());
        textView03.setText("Email: " + editText03.getText().toString());
    }
}