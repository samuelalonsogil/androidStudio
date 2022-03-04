package com.example.ejercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    public final static String tag = "SMS:";
    public EditText name,sms;
    public Button search;
    public ListView listView;

    public void initVariables(){
        name = findViewById(R.id.editTextName);
        sms = findViewById(R.id.editTextSMS);
        search = findViewById(R.id.buttonSearch);
        search.setOnClickListener(this);
        listView = findViewById(R.id.listViewContacts);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
    }


    @SuppressLint("Range")
    public void searchContacts(View view) {

        String[] proyeccion = {ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.HAS_PHONE_NUMBER,
                ContactsContract.Contacts.PHOTO_ID};

        String filtro = ContactsContract.Contacts.DISPLAY_NAME + " like ?";
        String[] args_filtro = {name.getText().toString() + "%"};
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, proyeccion, filtro, args_filtro, null);

        List<String> lista_contactos = new ArrayList<String>();

        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0)
                    lista_contactos.add(name);

            }
        }
        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.fila, lista_contactos));
        cur.close();
    }
    @SuppressLint("IntentReset")
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent();

        i.setAction(Intent.ACTION_SEND);
        i.setData(Uri.parse("mailto:"));
        String para[] =
                { "otrocontacto@gmail.com"};

        i.putExtra(Intent.EXTRA_EMAIL, para);
        i.putExtra(Intent.EXTRA_SUBJECT, "Saludos desde Android");
        i.putExtra(Intent.EXTRA_TEXT, "Hola!!. ¿Qué tal?. Este es nuestro primer email");
        i.setType("message/rfc822");
        startActivity(i);
        Toast.makeText(this.getApplicationContext(), "Envía el email!!", Toast.LENGTH_LONG).show();

        return true;
    }


    @Override
    public void onClick(View view) {
        searchContacts(view);
    }


}