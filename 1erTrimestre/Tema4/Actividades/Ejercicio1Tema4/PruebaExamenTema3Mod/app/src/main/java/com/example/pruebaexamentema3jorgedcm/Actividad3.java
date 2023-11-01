package com.example.pruebaexamentema3jorgedcm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;

public class Actividad3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tercer_layout);

        final RatingBar ratingBar = findViewById(R.id.ratingBar);
        final ImageView imagenNota = (ImageView) findViewById(R.id.imagenRating);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating == 1) {
                    imagenNota.setImageResource(R.drawable.unaestrella);
                }else if(rating == 2) {
                    imagenNota.setImageResource(R.drawable.dosestrellas);
                }else if(rating == 3) {
                    imagenNota.setImageResource(R.drawable.tresestrellas);
                }else if(rating == 4) {
                    imagenNota.setImageResource(R.drawable.cuatroestrellas);
                }else if(rating == 5) {
                    imagenNota.setImageResource(R.drawable.cincoestrellas);
                }
            }
        });
    }
}