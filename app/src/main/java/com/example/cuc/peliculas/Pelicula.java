package com.example.cuc.peliculas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by CUC on 1/06/2017.
 */

public class Pelicula {

    private String foto, nombre, descripcion, genero;

    public Pelicula(String foto, String nombre, String descripcion, String genero) {
        this.foto = foto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.genero = genero;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void guardar(Context contexto){
        SQLiteDatabase db;
        String sql;

        PeliculasSQLiteOpenHelper aux = new PeliculasSQLiteOpenHelper(contexto, "DBPeliculas",null);
        db = aux.getWritableDatabase();

        sql = "INSERT INTO Peliculas values('"+this.getFoto()+"','"
                +this.getNombre()+"','"
                +this.getDescripcion()+"','"
                +this.getGenero()+"')";

        db.execSQL(sql);

        db.close();
    }
}
