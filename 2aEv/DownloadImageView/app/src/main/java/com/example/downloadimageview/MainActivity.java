package com.example.downloadimageview;

import androidx.appcompat.app.AppCompatActivity;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText editText;
    public ImageView imageView;
    public Button button;

    public void initVariables(){
        editText = findViewById(R.id.editTextURL);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        button.setOnClickListener(MainActivity.this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
    }

    @Override
    public void onClick(View view) {
        new DownloadImage();
    }

    public class DownloadImage extends AsyncTask<String, Void, Bitmap>{

        public InputStream inputStream;

        @Override
        protected void onPreExecute() {super.onPreExecute();}

        @Override
        protected Bitmap doInBackground(String... url) {
            String imageURL = url[0];

            try {
                inputStream = new URL(imageURL).openStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return BitmapFactory.decodeStream(inputStream);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }


    }
}