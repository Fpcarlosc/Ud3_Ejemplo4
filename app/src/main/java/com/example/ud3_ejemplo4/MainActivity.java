package com.example.ud3_ejemplo4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buscamos el TextView de la actividad 1 por su id (actividad1).
        TextView actividad1 = findViewById(R.id.actividad1);

        // Asignamos un Click Listener sobre el TextView
        actividad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAct1 = new Intent(MainActivity.this, Actividad1.class);
                // Añadimos los datos extra para pasárselos a la actividad
                intentAct1.putExtra(Intent.EXTRA_TEXT,"Texto Actividad 1");
                startActivity(intentAct1);
            }
        });

        // Buscamos el TextView de la actividad 2 por su id (actividad2).
        TextView actividad2 = findViewById(R.id.actividad2);

        // Asignamos un Click Listener sobre el TextView
        actividad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAct2 = new Intent(MainActivity.this, Actividad2.class);

                // Añadimos los datos extra para pasárselos a la actividad
                intentAct2.putExtra(Intent.EXTRA_TEXT,"Texto Actividad 2");
                startActivity(intentAct2);
            }
        });
    }
}
