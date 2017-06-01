package com.example.cuc.peliculas;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Detalle extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private String nombre, descripcion, foto, genero;
    private Bundle b;
    private Intent i;
    private ImageView ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        TextView descrip = (TextView)findViewById(R.id.txtDescripcionD);
        TextView gene = (TextView)findViewById(R.id.txtGeneroD);

        i = getIntent();

        b=i.getBundleExtra("datos");
        nombre = b.getString("nombre");
        descripcion = b.getString("descripcion");
        foto = b.getString("foto");
        genero = b.getString("genero");

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        ft = (ImageView)findViewById(R.id.fotoPelicula);
        //Picasso.with(getApplicationContext()).load(foto).into(ft);
        ft.setImageResource(Integer.parseInt(foto));
        collapsingToolbarLayout.setTitle(nombre);
        descrip.setText(descripcion);
        gene.setText(genero);
    }
}
