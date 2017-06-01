package com.example.cuc.peliculas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by CUC on 31/05/2017.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.PeliculaViewHolder>{

    private ArrayList<Pelicula> peliculas;
    private OnPeliculaClickListener clickListener;

    public Adaptador(ArrayList<Pelicula> peliculas, OnPeliculaClickListener clickListener) {
        this.peliculas = peliculas;
        this.clickListener = clickListener;
    }

    @Override
    public PeliculaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new PeliculaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PeliculaViewHolder holder, int position) {
        final Pelicula p = peliculas.get(position);


        holder.nombre.setText(p.getNombre());
        holder.descripcion.setText(p.getDescripcion());
        holder.genero.setText(p.getGenero());
        //Picasso.with(holder.view.getContext()).load(p.getFoto()).into(holder.foto);
        holder.foto.setImageResource(Integer.parseInt(p.getFoto()));

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onPeliculaClick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public static class PeliculaViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView nombre;
        private TextView descripcion;
        private TextView genero;
        private View view;

        public PeliculaViewHolder(View itemView) {
            super(itemView);
            view= itemView;
            foto = (ImageView)itemView.findViewById(R.id.foto);
            nombre = (TextView)itemView.findViewById(R.id.txtNombreP);
            descripcion = (TextView)itemView.findViewById(R.id.txtDescripcionP);
            genero = (TextView)itemView.findViewById(R.id.txtGeneroP);
        }
    }

    public interface OnPeliculaClickListener{
        void onPeliculaClick(Pelicula p);
    }
}
