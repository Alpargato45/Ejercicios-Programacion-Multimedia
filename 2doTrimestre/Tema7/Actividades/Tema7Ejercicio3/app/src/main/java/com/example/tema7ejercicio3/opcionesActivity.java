package com.example.tema7ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;

public class opcionesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.opciones);

        Preference.OnPreferenceClickListener listener = new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                String key = preference.getKey();
                if(key.equals("ajustesAdicionales")) {
                    startActivity(new Intent(opcionesActivity.this, ajustesAdicionalesActivity.class));
                }
                if(key.equals("programarHora")) {
                        findPreference("horaIniciar").setEnabled(((SwitchPreference) preference).isChecked());
                        findPreference("horaFinalizar").setEnabled(((SwitchPreference) preference).isChecked());
                        findPreference("horaRepetir").setEnabled(((SwitchPreference) preference).isChecked());
                }
                return true;
            }
        };
        findPreference("ajustesAdicionales").setOnPreferenceClickListener(listener);
        findPreference("programarHora").setOnPreferenceClickListener(listener);
    }
}