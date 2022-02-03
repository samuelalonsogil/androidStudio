package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public EditText input;
    public TextView output;
    public Button button01;

    public void initVariables(){
        input = findViewById(R.id.editTextInput);
        output = findViewById(R.id.outPut);
        button01 = findViewById(R.id.buttonCalculate);
        button01.setOnClickListener(MainActivity.this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
    }

    public void calculate(View view){

        int n = Integer.parseInt(input.getText().toString());
        output.append(n + " ! = ");
        int res = factorial(n);
        output.append(res + "\n");

        MyTask task = new MyTask();
        task.execute();
    }

    public int factorial(int n){
        int res = 1;
        for(int i=1; i<=n; i++){
            res *=i;
            //forzando un retardo en el calculo
            SystemClock.sleep(1000);
        }
        return res;
    }

    @Override
    public void onClick(View view) {
        calculate(view);
    }
}