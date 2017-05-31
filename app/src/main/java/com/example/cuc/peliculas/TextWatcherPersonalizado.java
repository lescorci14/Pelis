package com.example.cuc.peliculas;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by CUC on 31/05/2017.
 */

public abstract class TextWatcherPersonalizado implements TextWatcher {

    private TextInputLayout icaja;
    private String error;

    public TextWatcherPersonalizado(TextInputLayout icaja, String error) {
        this.icaja = icaja;
        this.error = error;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if(estaVacio(s)) icaja.setError(error);
        else if(icaja.isErrorEnabled()){
            icaja.setError(null);
        }
    }

    public abstract boolean estaVacio(Editable s);
}
