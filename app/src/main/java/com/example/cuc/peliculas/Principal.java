package com.example.cuc.peliculas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements Adaptador.OnPeliculaClickListener{
    private RecyclerView listado;
    private Intent i;
    private ArrayList<Pelicula> peliculas;
    private Adaptador adapter;
    private LinearLayoutManager llm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        listado = (RecyclerView) findViewById(R.id.lstOpciones);

        peliculas = Datos.traerPeliculas(getApplicationContext());
        adapter = new Adaptador(peliculas,this);

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listado.setLayoutManager(llm);
        listado.setAdapter(adapter);
    }


    public void agregar(View v){
        finish();
        Intent i = new Intent(Principal.this, Agregar.class);
        startActivity(i);
    }

    @Override
    public void onPeliculaClick(Pelicula p) {
        //finish();
        Intent i = new Intent(Principal.this,Detalle.class);
        Bundle b = new Bundle();
        b.putString("nombre",p.getNombre());
        b.putString("descripcion",p.getDescripcion());
        b.putString("foto",p.getFoto());
        b.putString("genero",p.getGenero());

        i.putExtra("datos",b);
        startActivity(i);
    }
}
