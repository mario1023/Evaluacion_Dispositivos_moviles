package com.example.mario.evaluacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    ListView lista;
    public static int LISTA=2;
    ArrayList<Estudiante> listaNueva, listaRecibido;
    private AdaptadorEstudiante adaptadorEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        this.lista = findViewById(R.id.lista);

        Bundle contenedor = getIntent().getExtras();
        listaRecibido = (ArrayList<Estudiante>) contenedor.getSerializable("array");
        listaNueva = new ArrayList<>();
        adaptadorEstudiante = new AdaptadorEstudiante(ListaActivity.this,listaNueva);
        lista.setAdapter(adaptadorEstudiante);
        ListaEstudiantes();
    }

    private void ListaEstudiantes(){
        for (final Estudiante c:listaRecibido){
            listaNueva.add(c);
            adaptadorEstudiante.notifyDataSetChanged();
        }
    }

}
