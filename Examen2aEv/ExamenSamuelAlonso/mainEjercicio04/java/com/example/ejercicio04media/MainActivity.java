package com.example.ejercicio04media;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAudio,buttonVideo, buttonCamera;
    MediaPlayer mediaPlayer;
    TextView textView;
    VideoView videoView;
    ImageView imageView;

    final int PHOTO_RESULT=1;
    private Uri mLastPhotoURI=null;

    public void initVariables(){
        imageView = findViewById(R.id.imageView);
        videoView = findViewById(R.id.videoView);

        textView = findViewById(R.id.textViewMedia);

        mediaPlayer = MediaPlayer.create(this, R.raw.adrenalina);

        buttonAudio = findViewById(R.id.buttonAudio);
        buttonAudio.setOnClickListener(this);

        buttonVideo = findViewById(R.id.buttonVideo);
        buttonVideo.setOnClickListener(this);

        buttonCamera = findViewById(R.id.buttonCamera);
        buttonCamera.setOnClickListener(this);
    }


    public Uri createFileURI() {
        @SuppressLint("SimpleDateFormat") String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(System.currentTimeMillis());
        String fileName = "PHOTO_" + timeStamp + ".jpg";
        return Uri.fromFile(new File(Environment.
                getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),fileName));
    }

    public void takePicture(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            mLastPhotoURI = createFileURI();
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, mLastPhotoURI);
            startActivityForResult(takePictureIntent, PHOTO_RESULT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PHOTO_RESULT && resultCode == RESULT_OK) {
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(mLastPhotoURI.getPath()));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        }
    }

    @SuppressLint("SetTextI18n")
    public void play(View view){
        if (mediaPlayer.isPlaying())
            textView.setText(" ya estás reproduciendo audio");

        else {
            mediaPlayer.start();
            textView.setText("reproduciendo");
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == buttonAudio.getId() ) play(view);
        else if(view.getId() == buttonVideo.getId() ){
            videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.ben_ten_opening_castellano);
            videoView.start();

        }else if (view.getId() == buttonCamera.getId() ){
            takePicture(view);
        }
    }
}