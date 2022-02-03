package com.example.asynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.SystemClock;

public class MyTask extends AsyncTask<Integer, Integer, Integer> {

    private ProgressDialog progressDialog;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage("Calculando...");
        progressDialog.setCancelable(false);
        progressDialog.setMax(100);
        progressDialog.setProgress(0);
        progressDialog.show();
    }

    @Override
    protected Integer doInBackground(Integer... n) {
        int res = 1;
        for(int i = 1; i <=n[0]; i++){
            res *= i;
            SystemClock.sleep(1000);
            publishProgress(i*100/n[0]);
        }
        return res;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }

    @Override
    protected void onProgressUpdate(Integer... porc) {
        progressDialog.setProgress(porc[0]);
    }
}
