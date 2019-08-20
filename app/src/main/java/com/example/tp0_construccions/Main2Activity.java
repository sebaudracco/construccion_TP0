package com.example.tp0_construccions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static java.lang.Math.toIntExact;

public class Main2Activity extends AppCompatActivity {
    private EditText et1,et2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);

    }

    public void grabar(View v) {
        int numero= Integer.parseInt(et1.getText().toString());
        String nombre=et2.getText().toString();
        if(numero>=0 && numero<1000)
        {
            try {
                long msTime = System.currentTimeMillis();
                Date date = new Date(msTime);
                SimpleDateFormat f = new SimpleDateFormat("EEEE, MMMM d '' hh:mm a 'del año' yyyy G");
                String DiaFechaHora = f.format(date);

                OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                        numero + nombre, Activity.MODE_PRIVATE));
                archivo.write(et1.getText().toString());
                archivo.write(et2.getText().toString());
                archivo.write(DiaFechaHora.toString());
                archivo.flush();
                archivo.close();

            } catch (IOException e) {
                Toast t = Toast.makeText(this, "Imposible Grabar!",
                        Toast.LENGTH_SHORT);
                t.show();
            }
            Toast t = Toast.makeText(this, "Los datos fueron grabados",
                    Toast.LENGTH_SHORT);
            t.show();
            et1.setText("");
            et2.setText("");
            Intent intent = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(intent);

        }
        else
        {
            Toast.makeText(Main2Activity.this,"Por favor, ingrese un numero de 3 cifras!",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(intent);
            et1.setText("");
            et2.setText("");
        }
    }

}
