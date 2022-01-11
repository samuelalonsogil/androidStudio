package com.example.ui_basics_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {


    private CheckBox checkBox01, checkBox02, checkBox03;
    private RadioGroup radioGroup01;
    private ProgressBar progressBar01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox01 = findViewById(R.id.checkBoxSW01);
        checkBox02 = findViewById(R.id.checkBoxSW02);
        checkBox03 = findViewById(R.id.checkBoxSW03);

        checkBox01.setOnCheckedChangeListener(this);
        onCheckedChanged02(checkBox02);
        onCheckedChanged03(checkBox03);

        buttonsUnchecked(checkBox01, checkBox02, checkBox03);

        progressBar01 = findViewById(R.id.progressBar01);

        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i = 0; i < 100; i++){
                    progressBar01.incrementProgressBy(1);
                    SystemClock.sleep(500);
                }
            }
        });
        thread01.start();

        radioGroup01 = findViewById(R.id.radioGroup);
        radioGroup01.setOnCheckedChangeListener((group, checkedId) -> {

            if (R.id.radioButton01 == checkedId)
                Toast.makeText(MainActivity.this, "Hijo de puta", Toast.LENGTH_SHORT).show();

            else if(R.id.radioButton02 == checkedId){

                Toast.makeText(MainActivity.this, "Cabron", Toast.LENGTH_SHORT).show();
                progressBar01.setVisibility(View.GONE);
            }

            else if(R.id.radioButton03 == checkedId)
                Toast.makeText(MainActivity.this, "Puto viejo maricon", Toast.LENGTH_SHORT).show();
        });



    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked) Toast.makeText(this, "Are you an angel?", Toast.LENGTH_SHORT).show();
        else Toast.makeText(MainActivity.this, "no mola", Toast.LENGTH_SHORT).show();
    }

    public void onCheckedChanged02(View view) {
        checkBox02.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) Toast.makeText(MainActivity.this, "I don't like sand", Toast.LENGTH_SHORT).show();
            else Toast.makeText(MainActivity.this, "no mola nada", Toast.LENGTH_SHORT).show();
        });

    }

    public void onCheckedChanged03(View view) {
        checkBox03.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) Toast.makeText(MainActivity.this, "Hello there!", Toast.LENGTH_SHORT).show();
            else Toast.makeText(MainActivity.this, "vete a la mierda", Toast.LENGTH_SHORT).show();
        });
    }


    public void buttonsUnchecked(View view, View view02,View view03 ){
        if (!checkBox01.isChecked() && !checkBox02.isChecked() && !checkBox03.isChecked())
            Toast.makeText(this, "Go watch something", Toast.LENGTH_SHORT).show();

    }
}