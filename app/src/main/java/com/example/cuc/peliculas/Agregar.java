package com.example.cuc.peliculas;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Agregar extends AppCompatActivity {
    private EditText cajaNombre, cajaDescripcion;
    private Spinner comboImagenes;
    private ArrayAdapter adapter;
    private String[] opc;
    private boolean guardado;
    private TextInputLayout icajaNombre, icajaDescripcion;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);


        res = this.getResources();
        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaDescripcion = (EditText)findViewById(R.id.txtDescripcion);

        icajaNombre = (TextInputLayout)findViewById(R.id.nombePelicula);
        icajaDescripcion = (TextInputLayout)findViewById(R.id.descripcionPelicula);
        comboImagenes = (Spinner)findViewById(R.id.cmbImg);
        opc = res.getStringArray(R.array.imagenes);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc);
        comboImagenes.setAdapter(adapter);
        guardado = false;

        cajaNombre.addTextChangedListener(new TextWatcherPersonalizado(icajaNombre, res.getString(R.string.error1)) {
            @Override
            public boolean estaVacio(Editable s) {
                if(TextUtils.isEmpty(s) && !guardado) return true;
                else return false;
            }
        });

        cajaDescripcion.addTextChangedListener(new TextWatcherPersonalizado(icajaDescripcion, res.getString(R.string.error2)) {
            @Override
            public boolean estaVacio(Editable s) {
                if(TextUtils.isEmpty(s) && !guardado) return true;
                else return false;
            }
        });
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(Agregar.this, Principal.class);
        startActivity(i);
    }

    public void limpiar(){
        cajaNombre.setText("");
        cajaDescripcion.setText("");
        cajaNombre.requestFocus();
        guardado = false;
    }

    public boolean validar(){
        if(cajaNombre.getText().toString().isEmpty()){
            icajaNombre.setError(res.getString(R.string.error1));
            cajaNombre.requestFocus();
            return false;
        }
        if (cajaDescripcion.getText().toString().isEmpty()){
            icajaDescripcion.setError(res.getString(R.string.error2));
            cajaDescripcion.requestFocus();
            return false;
        }

        return true;
    }

    public void guardar(View v){
        String img,nombre,descripcion,genero,f;
        int ft=0;
        Pelicula p;
        if(validar()){
            nombre = cajaNombre.getText().toString();
            descripcion = cajaDescripcion.getText().toString();
            genero = comboImagenes.getSelectedItem().toString();
            img = comboImagenes.getSelectedItem().toString();

            if(img.equalsIgnoreCase(res.getString(R.string.ima1))){
                ft = 0;
            }
            if(img.equalsIgnoreCase(res.getString(R.string.ima2))){
                ft = 1;
            }
            if(img.equalsIgnoreCase(res.getString(R.string.ima3))){
                ft = 2;
            }
            if(img.equalsIgnoreCase(res.getString(R.string.ima4))){
                ft = 3;
            }
            if(img.equalsIgnoreCase(res.getString(R.string.ima5))){
                ft = 4;
            }

            f = String.valueOf(fotoSeleccionada(ft));

            p = new Pelicula(f,nombre,descripcion, genero);
            p.guardar(getApplicationContext());

            Snackbar.make(v,getResources().getString(R.string.guardado), Snackbar.LENGTH_SHORT).show();
            guardado = true;
            limpiar();
        }
    }

    public int fotoSeleccionada(int numero){
        int fotos[] = {R.drawable.becarios,R.drawable.historiavenganza,R.drawable.lapurga,R.drawable.lomejordemi,R.drawable.university};
        return fotos[numero];
    }

    public void borrar(View v){
        limpiar();
    }
}
