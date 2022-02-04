package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText entrada;
    private TextView salida;
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada = findViewById(R.id.editTextInput);
        salida = findViewById(R.id.outPut);
        button = findViewById(R.id.buttonCalculate);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        calcularOperacion(view);
    }

    class MiThread extends Thread {
        private int n, res;

        public MiThread(int n){
            this.n = n;
        }

        @Override
        public void run(){
            res = factorial(n);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    salida.append(res + "\n");
                }
            });
        }
    }

    public void calcularOperacion(View view){
        int n = Integer.parseInt(entrada.getText().toString());
        salida.append(n + " ! = ");
        MiTarea tarea = new MiTarea();
        tarea.execute(n);
    }

    public int factorial(int n){
        int res = 1;
        for(int i=1; i<=n; i++){
            res *=i;
            SystemClock.sleep(1000);
        }
        return res;
    }

    class MiTarea extends AsyncTask< Integer, Integer, Integer > {
        private ProgressDialog progreso;

        @Override
        protected void onPreExecute(){
            progreso = new ProgressDialog(MainActivity.this);
            progreso.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progreso.setMessage("Calculando...");
            progreso.setCancelable(false);
            progreso.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            MiTarea.this.cancel(true);
                        }
                    });
            progreso.setMax(100);
            progreso.setProgress(0);
            progreso.show();
        }

        protected Integer doInBackground(Integer... n){
            int res = 1;
            for(int i = 1; i <=n[0] && !isCancelled(); i++){
                res *= i;
                SystemClock.sleep(1000);
                publishProgress(i*100/n[0]);
            }
            return res;
        }

        protected void onProgressUpdate(Integer... porc){
            progreso.setProgress(porc[0]);
        }

        @Override
        protected void onCancelled(){
            salida.append("Cancelado\n");
        }

        protected void onPostExecute(Integer res){
            progreso.dismiss();
            salida.append(res + "\n");
        }

    }
}