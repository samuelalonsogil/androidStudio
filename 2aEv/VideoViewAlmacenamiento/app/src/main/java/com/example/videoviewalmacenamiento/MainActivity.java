package com.example.videoviewalmacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView mVideoView;

    //ruta hasta el recurso
    String srcPath = "/sdcard/video.webm";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoView = (VideoView) findViewById(R.id.videoView);

        //RUTA LOCAL
        //mVideoView.setVideoPath(srcPath);

        //RUTA STREAMING
        mVideoView.setVideoURI(Uri.parse("https://upload.wikimedia.org/wikipedia/commons/transcoded/a/ab/Ejemplo_Potencia.webm/Ejemplo_Potencia.webm.360p.vp9.webm"));
        //ganamos os controles de media
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.requestFocus();
        mVideoView.start();


    }
}