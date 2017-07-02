package com.example.fabio.barcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import static android.R.id.edit;

public class Compilazione extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String ciao = getSharedPreferences("app",MODE_PRIVATE).getString("Barcode","");
        setContentView(R.layout.activity_compilazione);
        EditText e = (EditText)findViewById(R.id.NArticolo);
        e.setText(""+ciao);
        e.setFocusable(true);
        EditText e2 = (EditText)findViewById(R.id.Quantita);
        EditText e3 = (EditText)findViewById(R.id.Descrizione);
    }
}
