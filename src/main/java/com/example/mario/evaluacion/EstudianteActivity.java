package com.example.mario.evaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class EstudianteActivity extends AppCompatActivity {

    EditText txtnombre,txtcodigo,txtmateria,parcial1,parcial2,parcial3;
    Button btnGuardar;
    public static int ENVIODATOS=48;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante);
        this.txtnombre = findViewById(R.id.txtnombre);
        this.txtcodigo = findViewById(R.id.txtcodigo);
        this.txtmateria = findViewById(R.id.txtmateria);
        this.parcial1 = findViewById(R.id.txtparcila1);
        this.parcial2 = findViewById(R.id.txtparcila2);
        this.parcial3 = findViewById(R.id.txtparcila3);
        this.btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    guardarEstudiante();
            }
        });


    }

    void guardarEstudiante(){
      try{
          Double promedio = (Double.parseDouble(parcial1.getText().toString())*0.30) + (Double.parseDouble(parcial2.getText().toString())*0.30) +
                  (Double.parseDouble(parcial3.getText().toString())*0.40);
          Intent resultIntent = new Intent();
          resultIntent.putExtra("nombre",txtnombre.getText().toString());
          resultIntent.putExtra("codigo",txtcodigo.getText().toString());
          resultIntent.putExtra("materia",txtmateria.getText().toString());
          resultIntent.putExtra("parcial1",parcial1.getText().toString());
          resultIntent.putExtra("parcial2",parcial2.getText().toString());
          resultIntent.putExtra("parcial3",parcial3.getText().toString());
          resultIntent.putExtra("promedio",String.format("%.2f",promedio));
          setResult(MainActivity.ENVIODATOS, resultIntent);
          finish();
      }catch (Exception e){
          Toast.makeText(EstudianteActivity.this,"No puede dejar campos vacios!!",Toast.LENGTH_SHORT).show();
      }

    }

}
