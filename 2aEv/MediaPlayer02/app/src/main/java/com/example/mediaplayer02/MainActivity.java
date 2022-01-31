package com.example.mediaplayer02;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {


    public ImageButton forwardButton, backwardButton, pauseButton, playButton;
    public MediaPlayer mediaPlayer;
    public TextView songName, startTime, songTime;
    public SeekBar songProgress;
    public static int oTime =0, sTime =0, eTime =0, fTime = 5000, bTime = 5000;
    public Handler handler = new Handler();

    public void initVariables(){

        backwardButton = findViewById(R.id.btnBackward);
        forwardButton = findViewById(R.id.btnForward);
        playButton = findViewById(R.id.btnPlay);
        pauseButton = findViewById(R.id.btnPause);
        songName = findViewById(R.id.txtSname);
        startTime = findViewById(R.id.txtStartTime);
        songTime = findViewById(R.id.txtSongTime);

        songName.setText("Baitikochi Chuste");
        mediaPlayer = MediaPlayer.create(this, R.raw.baitikochi_chuste);
        songProgress = (SeekBar)findViewById(R.id.sBar);
        songProgress.setClickable(false);
        pauseButton.setEnabled(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Playing Audio", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                eTime = mediaPlayer.getDuration();
                sTime = mediaPlayer.getCurrentPosition();
                if(oTime == 0){
                    songProgress.setMax(eTime);
                    oTime =1;
                }
                songTime.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(eTime),
                        TimeUnit.MILLISECONDS.toSeconds(eTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS. toMinutes(eTime))) );
                startTime.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(sTime),
                        TimeUnit.MILLISECONDS.toSeconds(sTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS. toMinutes(sTime))) );
                songProgress.setProgress(sTime);
                handler.postDelayed(UpdateSongTime, 100);
                pauseButton.setEnabled(true);
                playButton.setEnabled(false);
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                pauseButton.setEnabled(false);
                playButton.setEnabled(true);
                Toast.makeText(getApplicationContext(),"Pausing Audio", Toast.LENGTH_SHORT).show();
            }
        });
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((sTime + fTime) <= eTime)
                {
                    sTime = sTime + fTime;
                    mediaPlayer.seekTo(sTime);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Cannot jump forward 5 seconds", Toast.LENGTH_SHORT).show();
                }
                if(!playButton.isEnabled()){
                    playButton.setEnabled(true);
                }
            }
        });
        backwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((sTime - bTime) > 0)
                {
                    sTime = sTime - bTime;
                    mediaPlayer.seekTo(sTime);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Cannot jump backward 5 seconds", Toast.LENGTH_SHORT).show();
                }
                if(!playButton.isEnabled()){
                    playButton.setEnabled(true);
                }
            }
        });
    }
    private Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            sTime = mediaPlayer.getCurrentPosition();
            startTime.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(sTime),
                    TimeUnit.MILLISECONDS.toSeconds(sTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(sTime))) );
            songProgress.setProgress(sTime);
            handler.postDelayed(this, 100);
        }
    };
}