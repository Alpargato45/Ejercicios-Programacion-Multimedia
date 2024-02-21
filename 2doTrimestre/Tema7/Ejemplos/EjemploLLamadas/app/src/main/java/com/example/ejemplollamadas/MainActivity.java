package com.example.ejemplollamadas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private static final int PERMISSION_REQUEST_CONTACTS = 0;
    private static final int PERMISSION_REQUEST_CALL_LOG = 1;

    private Button btnLlamada;
    private TextView txtResultado;
    private LinearLayout vista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        btnLlamada = findViewById(R.id.btnLlamadas);
        txtResultado = findViewById(R.id.lblResultado);
        vista = findViewById(R.id.vistaPrincipal);

        //Accedo al content provider publico a partir de la api 22

        btnLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarLlamadas();
            }
        });

    }

    private void realizarLlamadas() {

        //Compruebo si los permisos para la llamada han sido concedidos
        //El manifest elijo el de android

        int permisosLecturaHistorial = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CALL_LOG);

        if (permisosLecturaHistorial != PackageManager.PERMISSION_GRANTED) {
            //Pido Permisos si no los tengo
            peticionPermisos(Manifest.permission.READ_CALL_LOG,new String[]{Manifest.permission.READ_CALL_LOG}, PERMISSION_REQUEST_CALL_LOG, "a los contactos");
        }else {
            //Los permisos han sido concedidos, compruebo las llamadas
            String[] columnas = {CallLog.Calls.TYPE, CallLog.Calls.NUMBER};
            Uri llamadasUri = CallLog.Calls.CONTENT_URI;
            ContentResolver cr = getContentResolver();
            Cursor cur = cr.query(llamadasUri, columnas, null,null,null);

            if (cur.moveToFirst()) {
                int tipo;
                String tipoLlamadas = "";
                String telefono;

                int colTipo = cur.getColumnIndex(CallLog.Calls.TYPE);
                int colTelefono = cur.getColumnIndex(CallLog.Calls.NUMBER);

                txtResultado.setText("");
                do {
                    tipo = cur.getInt(colTipo);
                    telefono = cur.getString(colTelefono);

                    if (tipo == CallLog.Calls.INCOMING_TYPE) {
                        tipoLlamadas = "ENTRADA";
                    }else if (tipo == CallLog.Calls.OUTGOING_TYPE) {
                        tipoLlamadas = "SALIDA";
                    }else if (tipo == CallLog.Calls.MISSED_TYPE) {
                        tipoLlamadas = "PERDIDAS";
                    }
                    txtResultado.append(tipoLlamadas + " - " + telefono + "\n");
                }while (cur.moveToNext());
            }
        }
    }

    private void peticionPermisos(String permiso,final String[] manifest, final int id, String tipo) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,permiso)) {
            Snackbar.make(vista,"Es necesario el acceso " + tipo + " para su gestión de la app", Snackbar.LENGTH_INDEFINITE).setAction("ACEPTAR", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ActivityCompat.requestPermissions(MainActivity.this,manifest,id);
                }
            }).show();
        }else {
            ActivityCompat.requestPermissions(MainActivity.this,manifest,id);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case PERMISSION_REQUEST_CALL_LOG:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Snackbar.make(vista,"Permiso de lectura del historial establecido",Snackbar.LENGTH_LONG).show();
                }else {
                    Snackbar.make(vista,"Permiso de lectura de contactos denegado",Snackbar.LENGTH_LONG).show();
                }
        }
    }
}