package com.example.sqlloader;

import android.content.Context;
import android.database.Cursor;

import androidx.annotation.NonNull;
import androidx.loader.content.CursorLoader;

public class DictionaryLoader extends CursorLoader {

    Context mContext;

    public DictionaryLoader(Context context) {
        super(context);
        mContext = context;
    }
    @Override
    public Cursor loadInBackground() {
        DiccionarioDatabase db = new DiccionarioDatabase(mContext);
        return db.getWordList();
    }
}
