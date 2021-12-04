package com.example.viedoview01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    VideoView videoView;
    MediaController mediaController;
    Button buttonLocal, buttonURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLocal = findViewById(R.id.button01);
        buttonURL = findViewById(R.id.button02);

        videoView = findViewById(R.id.videoView01);

        buttonLocal.setOnClickListener(this);
        buttonURL.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        if (v.getId() == R.id.button01) videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.ben_ten_opening_castellano);

        else videoView.setVideoPath("https://dm0qx8t0i9gc9.cloudfront.net/watermarks/video/zofDdqF/videoblocks-4k-timelapse-sequence-of-vancouver-canada-the-skyline-and-the-harbor-at-night_s5bm0ilgf__3d0f0f5f617a6f209a3ea068cbf323ab__P360.mp4");

        videoView.start();
    }
}