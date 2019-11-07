package com.example.cinem_avis.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseService extends SQLiteOpenHelper {
    public DatabaseService(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
            "CREATE TABLE " + DatabaseConfig.NAME + "(" +
                "ID not null primary key autoincrement" +
                DatabaseConfig.COLUMN_DATE + " DATETIME not null" +
                DatabaseConfig.COLUMN_DESCRIPTION + " TEXT not null" +
                DatabaseConfig.COLUMN_MUSIC_MARK + " FLOAT not null" +
                DatabaseConfig.COLUMN_REALISATION_MARK + " FLOAT not null" +
                DatabaseConfig.COLUMN_SCENARIO_MARK + " FLOAT not null" +
            ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseConfig.NAME);

        onCreate(db);
    }
}
