package com.example.saveinstance;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String KEY_COUNTER = "CONTADOR";
    private int counter = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            
    }

    public void onClickCounter(View view){
        counter++;

        //casteo obligatorio
        ( (TextView) findViewById(R.id.textView01)).setText("Counter: " + Integer.toString(counter) );
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        //guardamos info que nos interese
        outState.putInt(KEY_COUNTER, counter);
    }


    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);

        //recuperamos la info guardada
        counter = savedInstanceState.getInt(KEY_COUNTER);
    }




}