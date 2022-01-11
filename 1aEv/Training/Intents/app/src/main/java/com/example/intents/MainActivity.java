package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonAllBooks, buttonReading, buttonAlreadyRead
                , buttonWishList , buttonFavourite, buttonAbout;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        invitViews();
        buttonAllBooks.setOnClickListener(this);
    }

    private void invitViews() {

        buttonAllBooks = findViewById(R.id.button01);
        buttonReading = findViewById(R.id.button02);
        buttonAlreadyRead = findViewById(R.id.button03);
        buttonWishList = findViewById(R.id.button04);
        buttonFavourite = findViewById(R.id.button05);
        buttonAbout = findViewById(R.id.button06);
    }

    @Override
    public void onClick(View v) {
        if ( v.getId() == buttonAllBooks.getId() ) {
                                    //navigate between these 2 classes
            intent = new Intent(MainActivity.this, AllBooksActivity.class);
            startActivity(intent);
        }
    }
}