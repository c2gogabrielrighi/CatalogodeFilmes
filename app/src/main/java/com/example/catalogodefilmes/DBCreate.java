package com.example.catalogodefilmes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBCreate extends SQLiteOpenHelper {
    public static final String DB_NAME = "moviecatalog.db";
    public static final String DB_TABLE = "movies";
    public static final String MOV_PK = "_id";
    public static final String MOV_ID = "key";
    public static final String MOV_TITLE = "title";
    public static final String MOV_POSTER = "poster";
    public static final String MOV_OVERVIEW = "overview";
    public static final String MOV_POPULARITY = "popularity";
    public static final int DB_VERSION = 1;

    public DBCreate(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE " + DB_TABLE + "(" +
                MOV_PK + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                MOV_ID + " INTEGER," +
                MOV_TITLE + " TEXT," +
                MOV_POSTER + " TEXT," +
                MOV_OVERVIEW + " TEXT," +
                MOV_POPULARITY + " float)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il){
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        onCreate(db);
    }
}
