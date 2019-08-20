package com.example.tp0_construccions;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
    }



    public void recuperar(View v) {
        String numero=et1.getText().toString();
        numero=numero.replace('/','-');

        boolean enco=false;
        String[] archivos = fileList();
        for (int f = 0; f < archivos.length; f++)
            if (numero.equals(archivos[f]))
                enco= true;

            if (enco==true) {
            try {
                InputStreamReader archivo = new InputStreamReader(
                        openFileInput(numero));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                while (linea != null) {
                    todo = todo + linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                et2.setText(todo);
                Toast.makeText(this,"Ese numero ya  ha sido elegido por : "+ todo , Toast.LENGTH_LONG).show();
            } catch (IOException e) {

            }
        } else
        {
            Toast.makeText(this,"Esta Disponible!", Toast.LENGTH_LONG).show();
            Intent intent= new Intent (MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }
    }
}
