package com.example.ud3_ejemplo4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2);

        TextView texto = findViewById(R.id.TextViewAct2);

        // Si hay datos extra los mostramos.
        if (getIntent() != null && getIntent().hasExtra(Intent.EXTRA_TEXT)) {
            texto.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));
        }
    }
}