package com.example.menuopciones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int menOp1 = 1;
    private static final int menOp2 = 2;
    private static final int menOp3 = 3;
    private static final int menOp2_1 = 4;
    private static final int menOp2_2 = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    //Creo menú con Java

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,menOp1,Menu.NONE,"Opcion A desde Java");

        SubMenu smenu = menu.addSubMenu(Menu.NONE,menOp2,Menu.NONE,"Opcion B desde Java");
        smenu = menu.addSubMenu(Menu.NONE,menOp2_1,Menu.NONE,"Opcion 2.1 desde Java");
        smenu = menu.addSubMenu(Menu.NONE,menOp2_2,Menu.NONE,"Opcion 2.2 desde Java");

        menu.add(Menu.NONE,menOp3,Menu.NONE,"Opcion C desde Java");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case menOp1:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case menOp2:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case menOp3:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

    //Creo menú con XML

//        @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_principal,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        int opcion = item.getItemId();
//
//        //Como en el ejemplo voy a hacer lo mismo en todas las opciones del menú no voy a separar las distintas opciones en un else if
//        if (opcion == R.id.mnOp1 || opcion == R.id.mnOp2 || opcion == R.id.mnOp3 || opcion == R.id.mnOp2_1 || opcion == R.id.mnOp2_2) {
//            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
//            return true;
//        }else {
//            return super.onOptionsItemSelected(item);
//        }
//    }
}