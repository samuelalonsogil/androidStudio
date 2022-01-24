package com.example.preferences;

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
    public Button button;
    public TextView textView;
    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();

        sharedPreferences = getPreferences(MODE_PRIVATE);
        String name = sharedPreferences.getString(NAME,null);
        if(name == null) textView.setText("Bienvenido por primera vez");
        else textView.setText("Bienvenido otra vez" + name + "!");
    }

    public void initVariables(){
        textView.findViewById(R.id.textView01);
        editText = findViewById(R.id.editTextNombre);
        button = findViewById(R.id.button01);
        button.setOnClickListener(MainActivity.this);
    }

    public void saveName(View view){
        String name = editText.getText().toString();
        sharedPreferences = getPreferences(MODE_PRIVATE);
        sharedPreferences.edit().putString(NAME,name).commit();
    }

    @Override
    public void onClick(View view) {
        saveName(view);
    }
}