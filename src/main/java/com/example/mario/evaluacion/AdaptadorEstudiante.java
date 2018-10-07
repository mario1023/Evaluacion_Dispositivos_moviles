package com.example.mario.evaluacion;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorEstudiante extends ArrayAdapter<Estudiante>{
    public AdaptadorEstudiante( Context context,  List<Estudiante> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        Estudiante estudiante = getItem(position);
        //TODO inicializando el layout correspondiente al item (Contacto)
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_estudiante, parent, false);
        }

        TextView nombre =(TextView)convertView.findViewById(R.id.txtnombre);
        TextView codigo =(TextView)convertView.findViewById(R.id.txtcodigo);
        TextView materia =(TextView)convertView.findViewById(R.id.txtmateria);
        TextView id =(TextView)convertView.findViewById(R.id.txtId);

        if(position==0){
            position = 1;
        }else{
            position = position + 1;
        }
        id.setText(String.valueOf(position));
        nombre.setText(estudiante.nombre.toString());
        codigo.setText(estudiante.codigo.toString());
        materia.setText(estudiante.materia.toString() +": "+estudiante.promedio);


        return convertView;
    }
}
