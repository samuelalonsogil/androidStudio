package com.example.recursoficheros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView01);
        textView.setText(getText(this.getResources().openRawResource(R.raw.raw_text )));

        TextView textViewAsset = findViewById(R.id.textView02);
        try{
            textViewAsset.setText(getText(this.getAssets().open("asset_text.txt")));
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    private String getText(InputStream inputStream){
        StringBuilder stringBuilder = new StringBuilder();
        try{
            if (inputStream != null){
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String newLine = null;
                while((newLine = bufferedReader.readLine())!= null ){
                    stringBuilder.append(newLine + "\n");
                }
                inputStream.close();
            }
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
        return stringBuilder.toString();
    }
}