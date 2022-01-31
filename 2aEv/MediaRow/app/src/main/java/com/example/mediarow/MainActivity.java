package com.example.mediarow;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

/*
    A través de un identificador de recurso (audio o vídeo almacenado en el directorio de recursos res/raw)
    Mediante una ruta local a un archivo almacenado en el sistema, por ejemplo en nuestra tarjeta SD.
    Usando una URI (Uniform Resource Identifier) para reproducir contenido online (streaming).
    Desde un Content Provider.*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mediaPlayer;
    TextView textView;
    Button buttonPlay,buttonPause,buttonStop ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();

    }

    public void initVariables(){
        mediaPlayer = MediaPlayer.create(this, R.raw.adrenalina);
        textView = findViewById(R.id.textView01);
        buttonPlay = findViewById(R.id.button01);
        buttonPause = findViewById(R.id.button02);
        buttonStop = findViewById(R.id.button03);

        buttonPlay.setOnClickListener(MainActivity.this);
        buttonPause.setOnClickListener(MainActivity.this);
        buttonStop.setOnClickListener(MainActivity.this);
    }

    public void play(View view){
        if (mediaPlayer.isPlaying())
            textView.setText(R.string.playin);

        else {
            mediaPlayer.start();
            textView.setText(R.string.reproduciendo);
        }
    }

    public void pause(View view){
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            textView.setText(R.string.pausaste);
        }
        else {
            textView.setText(R.string.nada_que_pausar);
        }
    }

    public void stop(View view) throws IOException {
        if (mediaPlayer!=null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            try {
                mediaPlayer.prepare();
                textView.setText(R.string.parao);
            } catch (IOException | IllegalStateException e) {
                e.printStackTrace();
            }
        }
        else {
            textView.setText(R.string.nada_para_parar);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == buttonPlay.getId() ) play(view);
        else if (view.getId() == buttonPause.getId() ) pause(view);

        else if (view.getId() == buttonStop.getId() ) {
            try {
                stop(view);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}