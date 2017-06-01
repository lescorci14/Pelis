package com.example.cuc.peliculas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CUC on 1/06/2017.
 */

public class PeliculasSQLiteOpenHelper extends SQLiteOpenHelper{
    String sql= "CREATE TABLE Peliculas(foto text, nombre text, descripcion text, genero text)";
    private static int version=1;

    public PeliculasSQLiteOpenHelper(Context contexto, String name, SQLiteDatabase.CursorFactory factory){
        super(contexto,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Peliculas");
        db.execSQL(sql);
    }
}
