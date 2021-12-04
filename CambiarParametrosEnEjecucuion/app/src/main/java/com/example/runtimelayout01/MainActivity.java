package com.example.runtimelayout01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout linearLayout01;
    Button button01;
    TextView textview01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout01 = findViewById(R.id.linearLayoutFondo);
        textview01 = findViewById(R.id.textView01);
        button01 = findViewById(R.id.button01);

        button01.setOnClickListener(this);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {
        textview01.setText("Texto cambiado en runTime!");
        linearLayout01.setBackgroundColor(R.color.design_default_color_primary_dark);

                                            //casteo obligatorio
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
        params.leftMargin += 5;
    }
}