package com.example.fabio.barcode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Operatore;
    Spinner Inventario;
    private String[] arraySpinner;
    Button b;
    SharedPreferences s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Operatore =(EditText) findViewById(R.id.editText);
        Inventario=(Spinner) findViewById(R.id.spinner);
        b = (Button) findViewById(R.id.button);
        s = getSharedPreferences("app",MODE_PRIVATE);
        arraySpinner = new String[]{"Bologna","Roma","Milano"};

        if(Operatore.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_layout, arraySpinner);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        Inventario.setAdapter(adapter);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s.edit().putString("Operatore",Operatore.getText().toString()).apply();
                s.edit().putString("Inventario",Inventario.getSelectedItem().toString()).apply();
                if (s.contains("Operatore"))
                    Toast.makeText(getApplicationContext(),"salvato nelle shared",Toast.LENGTH_LONG);
                startActivity(new Intent(getApplicationContext(),Scaffale.class));
            }
        });
    }
}
