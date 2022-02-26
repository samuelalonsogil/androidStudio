package com.example.storingsimpledata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public final String NAME = "NAME";
    public EditText editText;
    public SharedPreferences sharedPreferences;
    public TextView textView;
    public Button button;

    public void saveName(View view){
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putString(NAME,editText.getText().toString());
        editor.apply();
    }

    public void checkName(String name){
        if (name == null) textView.setText("Hello");
        else textView.setText(name);
    }

    public void initVariables(){
        editText = findViewById(R.id.editTextName);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        sharedPreferences = getPreferences(MODE_PRIVATE);
        String name = sharedPreferences.getString(NAME, null);
        checkName(name);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
    }

    @Override
    public void onClick(View view) {
        saveName(view);
    }
}