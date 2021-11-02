package com.earr.practema02shapre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    EditText e1, e2;
    Button b1;
    public static final String archivo = "datos.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                String Nombre = e1.getText().toString();
                String Apellido = e2.getText().toString();
                FileOutputStream flujo = null;
                try {
                    flujo = openFileOutput(archivo, MODE_PRIVATE);
                    flujo.write(Nombre.getBytes());
                    flujo.write(Apellido.getBytes());
                    e1.setText("");
                    e2.getText().clear();
                    Toast.makeText(getApplicationContext(), "datos guardos" + getFilesDir()
                                    + "/" + archivo,
                            Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {

                    try {
                        flujo.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}
