package com.example.mario.evaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnNuevoE,btnLstE;
    static ArrayList<Estudiante> alumno;
    public static int ENVIODATOS=48;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnNuevoE = findViewById(R.id.btnNuevoE);
        this.btnLstE = findViewById(R.id.btnListE);
        alumno = new ArrayList<>();

        btnNuevoE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent estudiante = new Intent(MainActivity.this,EstudianteActivity.class);
                startActivityForResult(estudiante,ENVIODATOS);
            }
        });

        btnLstE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CargarlistaEstudiante();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ENVIODATOS) {
            if (data == null){
                return;
            }
                Estudiante estudiante = new Estudiante(
                        data.getStringExtra("nombre"),
                        data.getStringExtra("codigo"),
                        data.getStringExtra("materia"),
                        Double.parseDouble(data.getStringExtra("parcial1")),
                        Double.parseDouble(data.getStringExtra("parcial2")),
                        Double.parseDouble(data.getStringExtra("parcial3")),
                        Double.parseDouble(data.getStringExtra("promedio")));
           alumno.add(estudiante);
        }

    }

        private  void CargarlistaEstudiante(){
            Intent estudiante = new Intent(MainActivity.this, ListaActivity.class);
            Bundle contenedor = new Bundle();
            contenedor.putSerializable("array", alumno);
            estudiante.putExtras(contenedor);
            startActivity(estudiante);
        }


}
