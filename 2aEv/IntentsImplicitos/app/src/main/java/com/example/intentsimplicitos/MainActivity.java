package com.example.intentsimplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrir(View v) {
        Intent i = new Intent();
        Intent chooser = null;
        switch (v.getId()) {
            case R.id.button1:
                EditText edURL =
                        (EditText) findViewById(R.id.editText1);
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(edURL.getText().toString()));
                chooser = i.createChooser(i, "Elige Navegador");
                startActivity(i);
                Toast.makeText(this.getApplicationContext(), "Acceso a web!", Toast.LENGTH_LONG).show();
                break;
            case R.id.button2:
                EditText edLatitud =
                        (EditText) findViewById(R.id.editText2);
                EditText edLongitud =
                        (EditText) findViewById(R.id.editText3);
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:" + edLatitud.getText().toString() + " ," + edLongitud.getText().toString()));
                chooser = i.createChooser(i, "Lanzar Mapas");
                startActivity(i);
                Toast.makeText(this.getApplicationContext(), "Acceso a mapas!", Toast.LENGTH_LONG).show();
                break;
            case R.id.button3:
                EditText edEmail =
                        (EditText) findViewById(R.id.editText4);
                i.setAction(Intent.ACTION_SEND);
                i.setData(Uri.parse("mailto:"));
                String para[] =
                        {edEmail.getText().toString(), "otrocontacto@gmail.com"};
                i.putExtra(Intent.EXTRA_EMAIL, para);
                i.putExtra(Intent.EXTRA_SUBJECT, "Saludos desde Android");
                i.putExtra(Intent.EXTRA_TEXT, "Hola!!. ¿Qué tal?. Este es nuestro primer email");
                i.setType("message/rfc822");
                chooser = i.createChooser(i, "Enviar Email");
                startActivity(i);
                Toast.makeText(this.getApplicationContext(), "Envía el email!!", Toast.LENGTH_LONG).show();
                break;
        }
    }
}