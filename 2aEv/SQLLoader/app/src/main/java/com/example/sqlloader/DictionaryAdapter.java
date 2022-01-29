package com.example.sqlloader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class DictionaryAdapter extends CursorAdapter {
    TextView textView;

    public DictionaryAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context)
                .inflate(android.R.layout.simple_list_item_1,viewGroup,false);
    }

    @SuppressLint("Range")
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        textView = view.findViewById(android.R.id.text1);
        textView.setText(cursor.getString(getCursor().getColumnIndex("word")) );
    }
}
