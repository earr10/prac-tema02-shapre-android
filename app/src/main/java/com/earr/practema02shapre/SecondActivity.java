package com.earr.practema02shapre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    SharedPreferences preferences;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.textViewShared);

        preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        textView.append("Es casado: " + preferences.getBoolean("casado", false) + "\n");
        textView.append("Sueldo: " + preferences.getFloat("sueldo", 0) + "\n");
        textView.append("Edad: " + preferences.getInt("edad", 0) + "\n");
        textView.append("Código postal: " + preferences.getLong("cp", 5) + "\n");
        textView.append("Nombre: " + preferences.getString("nombre", "Nombrecito") + "\n");
    }
}