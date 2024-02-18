package com.example.examentema7jorgedcm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class activityConfiguracion extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preference_configuracion);
    }
}