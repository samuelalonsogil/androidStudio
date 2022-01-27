package com.example.sqlloader;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.loader.content.CursorLoader;

public class DictionaryLoader extends CursorLoader {
    public DictionaryLoader(@NonNull Context context) {
        super(context);
    }
}
