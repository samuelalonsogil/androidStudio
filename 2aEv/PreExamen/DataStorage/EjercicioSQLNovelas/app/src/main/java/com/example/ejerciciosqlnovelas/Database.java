package com.example.ejerciciosqlnovelas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "database";
    public static final String TABLE = "table";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_AUTHOR = "author";
    public static final String FIELD_COUNTRY = "country";
    public static final String FIELD_EDITORIAL = "editorial";
    public static final String FIELD_PRICE = "";
    public static final String FIELD_YEAR = "";
    public static final int DATABASE_VERSION = 1;

    public SQLiteDatabase sqLiteDatabase;

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(new StringBuilder().append("CREATE TABLE ").append(TABLE)
                .append(" (_id integer PRIMARY KEY,")
                .append(FIELD_TITLE).append(" TEXT, ")
                .append(FIELD_AUTHOR).append(" TEXT, ")
                .append(FIELD_COUNTRY).append(" TEXT, ")
                .append(FIELD_EDITORIAL).append(" TEXT, ")
                .append(FIELD_PRICE).append(" TEXT, ")
                .append(FIELD_YEAR).append(" TEXT ").toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { }

    public void saveRecord(String title, String author, String country, String editorial, String price, String year){
        long id = findTitleID(title);
        if (id>0) {
            updateRecord(id, title,author,country,editorial,price,year);
        } else {
            addRecord( title,author,country,editorial,price,year);
        }
    }


    public long findTitleID(String title) {
        long returnVal = -1;
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT _id FROM " + TABLE + " WHERE " + FIELD_TITLE + " = ?", new String[]{title});
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getInt(0);
        }
        return returnVal;
    }


    public long addRecord(String title, String author, String country, String editorial, String price, String year){
        sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put( FIELD_TITLE, title );
        values.put( FIELD_AUTHOR, author );
        values.put( FIELD_COUNTRY, country );
        values.put( FIELD_EDITORIAL, editorial );
        values.put(String.valueOf(FIELD_PRICE), price );
        values.put(String.valueOf(FIELD_YEAR), year );

        return sqLiteDatabase.insert( TABLE, null, values );
    }


    public int updateRecord(long id, String title, String author, String country, String editorial, String price, String year){
        sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put( "_id", id );
        values.put( FIELD_TITLE, title );
        values.put( FIELD_AUTHOR, author );
        values.put( FIELD_COUNTRY, country );
        values.put( FIELD_EDITORIAL, editorial );
        values.put(String.valueOf(FIELD_PRICE), price );
        values.put(String.valueOf(FIELD_YEAR), year );

        return sqLiteDatabase.update( TABLE, values, "_id = ?", new String[]{String.valueOf(id)} );
    }

    public int deleteRecord(long id){
        sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.delete( TABLE, "_id = ?", new String[]{String.valueOf(id)} );
    }

    public Cursor getNovelList(){
        sqLiteDatabase = getReadableDatabase();
        String query = " SELECT _id, " + FIELD_TITLE + " FROM " + TABLE + " ORDER BY " + FIELD_TITLE + " ASC " ;
        return sqLiteDatabase .rawQuery(query, null);
    }
}
