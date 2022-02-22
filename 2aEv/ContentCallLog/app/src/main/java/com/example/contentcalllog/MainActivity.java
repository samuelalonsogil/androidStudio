package com.example.contentcalllog;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.text.format.DateFormat;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Cursor c;
    public Uri llamadas;
    public TextView textViewSalida;
    public final String[] TIPO_LLAMADA = {"","entrante","saliente","perdida","mensaje de voz",
            "cancelada", "lista bloqueados" };

    public void initVariables(){
        textViewSalida = findViewById(R.id.salida);
        llamadas = Uri.parse("content://call_log/calls");
        c = getContentResolver().query(llamadas,null,
                null,null,null);
    }

    @SuppressLint("Range")
    public void getInformation(){
        while (c.moveToNext() ){
            textViewSalida.append(
                    "\n"
                    + DateFormat.format("dd/MM/yy k:mm (", c.getLong(c.getColumnIndex(CallLog.Calls.DATE) ) )
                    + c.getString(c.getColumnIndex(CallLog.Calls.DURATION)) + ") "
                    + c.getString(c.getColumnIndex(CallLog.Calls.NUMBER)) + ", "
                    + TIPO_LLAMADA[Integer.parseInt(c.getString( c.getColumnIndex(CallLog.Calls.TYPE) ) ) ] );
        }
        c.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        getInformation();

    }
}