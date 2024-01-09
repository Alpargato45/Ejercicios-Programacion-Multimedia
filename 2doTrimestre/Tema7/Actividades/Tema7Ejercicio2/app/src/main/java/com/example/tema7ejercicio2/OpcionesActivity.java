package com.example.tema7ejercicio2;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import androidx.annotation.Nullable;

public class OpcionesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.opciones);
    }
}
