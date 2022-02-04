package com.example.busquedahttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    TextView textViewSearch;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();

        /*preparamos el hilo de búsqueda*/
        StrictMode.setThreadPolicy( new StrictMode.ThreadPolicy.Builder().permitNetwork().build() );


    }

    public void search(View view){

        try{
            String textIntroduced = editText.getText().toString();
            String textSearched = googleSearch(textIntroduced);
            textViewSearch.append(textIntroduced + " --> " + textSearched + "\\n");
        
        }catch (Exception e) {
            textViewSearch.append("Error connecting");
            Toast.makeText(this, "Error connecting", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public String googleSearch(String text) throws IOException {
        StringBuilder web = new StringBuilder();
        String out="";

        URL url = new URL("https://www.google.es/search?hl=en&q=\""
                + URLEncoder.encode(text,"UTF-8") + "\"");

        HttpURLConnection connection = (HttpURLConnection)
                url.openConnection();

        //ESTAMOS INDICANDO EL BROWSER QUE VAMOS A UTILIZAR
        connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0;"
                + "Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) "
                + "Chrome/88.0.4324.104 Safari/537.36");

        if (connection.getResponseCode()==HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = reader.readLine();
            while (line!=null){
                web.append(line);
                line=reader.readLine();
            }
            reader.close();

            int ini = web.indexOf("About");
            if (ini != -1){
                int fin = web.indexOf(" ", ini + 16);
                out = web.substring(ini + 6, fin);
            } else {
                out = "no encontrado";
            }
        } else {
            textViewSearch.append("Error: " + connection.getResponseMessage() + "\n");
        }
        connection.disconnect();

        return out;
    }

    public void initVariables(){
        editText = findViewById(R.id.editTextSearch);
        textViewSearch = findViewById(R.id.textView01);
        button = findViewById(R.id.button01);
        button.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        search(view);
    }
}