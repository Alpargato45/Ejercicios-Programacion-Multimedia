package com.example.deezerwidgetactivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webView);

        // Configuración de la vista WebView
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);  // Habilitar JavaScript, ya que el widget de Deezer utiliza JavaScript
        webSettings.setAllowContentAccess(true);
        webSettings.setDomStorageEnabled(true);

        // Cargar el contenido del widget de Deezer en la vista WebView
        String deezerWidgetHtml = "<iframe id=\"deezer-widget\" src=\"https://widget.deezer.com/widget/dark/album/302127?app_id=457142&autoplay=false&radius=true&tracklist=true\" width=\"700\" height=\"300\" allowtransparency=\"true\" allowfullscreen=\"true\" allow=\"encrypted-media\"></iframe>";
        webView.loadData(deezerWidgetHtml, "text/html", null);
    }
}