package com.example.leer_y_escribirtextos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewRaw;
    TextView textViewAsset;
    StringBuilder stringBuilder;
    BufferedReader bufferedReader;
    Button buttonMostrarTexto, buttonEscribir, buttonIntroducir;
    EditText editText01, editText02;

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
        buttonIntroducir = findViewById(R.id.button03);
        editText01 = findViewById(R.id.editText01);
        editText02 = findViewById(R.id.editText02);
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


    public void writer(){
        try {
            FileWriter fileWriter01 = new FileWriter("src/main/assets/asset_text.txt");
            FileWriter fileWriter02 = new FileWriter("src/main/res/raw/raw_text.txt");

            fileWriter01.write(editText01.getText().toString());
            fileWriter02.write(editText02.getText().toString());

            fileWriter01.close();
            fileWriter02.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button01){
            initText();
        }else if(view.getId() == R.id.button02){
            editText01.setVisibility(View.VISIBLE);
            editText02.setVisibility(View.VISIBLE);
            buttonIntroducir.setVisibility(View.VISIBLE);

        }else if(view.getId() == R.id.button03){
            writer();
        }
    }
}