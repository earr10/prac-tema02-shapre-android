package com.earr.practema02shapre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnUno;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUno = findViewById(R.id.buttonShared);
    }

    public void preferencias(View v) {
        preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putBoolean("casado", false);
        editor.putFloat("sueldo", 20000);
        editor.putInt("edad", 22);
        editor.putLong("cp", 56600);
        editor.putString("nombre", "Erick");
        editor.commit();

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
        finish();
    }

    public void almacenamiento(View v) {
        Intent intent1 = new Intent(MainActivity.this, ThirdActivity.class);
        startActivity(intent1);
        finish();
    }
}