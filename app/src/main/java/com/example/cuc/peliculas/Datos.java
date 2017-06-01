package com.example.cuc.peliculas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by CUC on 31/05/2017.
 */

public class Datos {

    public static ArrayList<Pelicula> traerPeliculas(Context contexto){
        ArrayList<Pelicula> peliculas = new ArrayList<>();

        SQLiteDatabase db;
        String sql, foto, nombre, descripcion, genero;
        Pelicula p;

        PeliculasSQLiteOpenHelper aux = new PeliculasSQLiteOpenHelper(contexto,"DBPeliculas",null);
        db = aux.getReadableDatabase();
        sql = "select * from Peliculas";
        Cursor c = db.rawQuery(sql,null);

        if(c.moveToFirst()){
            do{
                foto = c.getString(0);
                nombre = c.getString(1);
                descripcion = c.getString(2);
                genero = c.getString(3);
                p = new Pelicula(foto,nombre,descripcion,genero);
                peliculas.add(p);
            }while (c.moveToNext());
        }
        db.close();
        return peliculas;
    }
}
