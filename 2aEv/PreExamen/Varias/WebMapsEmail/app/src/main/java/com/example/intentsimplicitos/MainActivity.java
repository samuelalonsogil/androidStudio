package com.example.intentsimplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextURL,editTextLatitud,editTextLongitud,editTextEmail;
    Button buttonURL, buttonMaps, buttonEmail;

    public void initVariables(){
        editTextURL = findViewById(R.id.editText1);
        editTextLatitud = findViewById(R.id.editText2);
        editTextLongitud = findViewById(R.id.editText3);
        editTextEmail = findViewById(R.id.editText4);
        buttonURL = findViewById(R.id.button1);
        buttonMaps = findViewById(R.id.button2);
        buttonEmail = findViewById(R.id.button3);

        buttonURL.setOnClickListener(this);
        buttonMaps.setOnClickListener(this);
        buttonEmail.setOnClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent();

        if (view.getId() == buttonURL.getId()   ){
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse(editTextURL.getText().toString()));
            startActivity(i);
            Toast.makeText(this.getApplicationContext(), "Acceso a web!", Toast.LENGTH_LONG).show();

        }else if(view.getId() == buttonMaps.getId() ){
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("geo:" + editTextLatitud.getText().toString() + " ," + editTextLongitud.getText().toString()));
            startActivity(i);
            Toast.makeText(this.getApplicationContext(), "Acceso a mapas!", Toast.LENGTH_LONG).show();

        }else if( view.getId() == buttonEmail.getId() ){
            i.setAction(Intent.ACTION_SEND);
            i.setData(Uri.parse("mailto:"));

            String para[] =
                    {editTextEmail.getText().toString(), "otrocontacto@gmail.com"};
            i.putExtra(Intent.EXTRA_EMAIL, para);
            i.putExtra(Intent.EXTRA_SUBJECT, "Saludos desde Android");
            i.putExtra(Intent.EXTRA_TEXT, "Hola!!. ¿Qué tal?. Este es nuestro primer email");
            i.setType("message/rfc822");
            startActivity(i);
            Toast.makeText(this.getApplicationContext(), "Envía el email!!", Toast.LENGTH_LONG).show();
        }
    }
}