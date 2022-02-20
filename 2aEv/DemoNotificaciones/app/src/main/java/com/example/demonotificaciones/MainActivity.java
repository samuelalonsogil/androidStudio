package com.example.demonotificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void crearNotificaciones(View view){
        int notify = 1;

        /*Novedad crear primero o buscar un canal específico  de notificación*/
        

        NotificationCompat.Builder constructorNotif = new NotificationCompat.Builder(this);
        constructorNotif.setSmallIcon(R.drawable.ic_stat_name);
        constructorNotif.setContentTitle("Mi notificación");
        constructorNotif.setContentText("Has recibido una notificación!!");

        /* PASO 2: Creamos un intent para abrir la actividad cuando se pulse la notificación*/
        Intent resultadoIntent = new Intent(this, MainActivity.class);

        //El objeto stackBuilder crea un back stack que nos asegura que el botón de "Atrás" del
        //dispositivo nos lleva desde la Actividad a la pantalla principal
        TaskStackBuilder pila = TaskStackBuilder.create(this);

        // El padre del stack será la actividad a crear
        pila.addParentStack(MainActivity.class);
        // Añade el Intent que comienza la Actividad al inicio de la pila
        pila.addNextIntent(resultadoIntent);
        PendingIntent resultadoPendingIntent = pila.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        constructorNotif.setContentIntent(resultadoPendingIntent);

        /* PASO 3: [Opcional] Crear notificación con layout expandible */
        NotificationCompat.InboxStyle inboxStyle =
                new NotificationCompat.InboxStyle();
        String[] eventos = new String[5];
        // Título del expanded layout
        inboxStyle.setBigContentTitle("Notificación expandible:");
        eventos[0]="Esto es la primera línea";
        eventos[1]="Esto es la segunda línea";
        eventos[2]="Esto es la tercera línea";
        eventos[3]="Esto es la cuarta línea";
        eventos[4]="Esto es la quita línea";
        // Mueve eventos dentro del expanded layout
        for (int i=0; i < eventos.length; i++) {

            inboxStyle.addLine(eventos[i]);
        }
        /* tope */
        constructorNotif.setWhen(0);
        constructorNotif.setPriority(Notification.PRIORITY_MAX);

        // Mueve el expanded layout a la notificación.
        constructorNotif.setStyle(inboxStyle);



        /* PASO 4. Crear y enviar */
        NotificationManager notificador =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificador.notify(notify, constructorNotif.build());
    }


    }

