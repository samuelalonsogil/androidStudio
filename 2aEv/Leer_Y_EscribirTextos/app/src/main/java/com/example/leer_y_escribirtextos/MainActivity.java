package com.example.leer_y_escribirtextos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewRaw;
    TextView textViewAsset;
    StringBuilder stringBuilder;
    BufferedReader bufferedReader;
    Button buttonMostrarTexto;
    Button buttonEscribir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();

        buttonMostrarTexto.setOnClickListener(this);
        buttonEscribir.setOnClickListener(this);
    }

    public void initVariables(){
        textViewRaw = findViewById(R.id.textView01);
        textViewAsset = findViewById(R.id.textView02);
        buttonMostrarTexto = findViewById(R.id.button01);
        buttonEscribir = findViewById(R.id.button02);
    }

    public void initText(){
        textViewRaw.setText(getText(this.getResources().openRawResource(R.raw.raw_text )));
        try{
            textViewAsset.setText(getText(this.getAssets().open("asset_text.txt")));
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    private String getText(InputStream inputStream){
        stringBuilder = new StringBuilder();
        try{
            if (inputStream != null){
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String newLine = null;
                while( (newLine = bufferedReader.readLine()) != null ){
                    stringBuilder.append(newLine + "\n");
                }
                inputStream.close();
            }
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
        return stringBuilder.toString();
    }



    @Override
    public void onClick(View view) {
        if (buttonMostrarTexto.getId() == R.id.button01){
            initText();
        }else{

        }
    }
}