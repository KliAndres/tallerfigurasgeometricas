package com.example.figurastaller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class OperacionesRealizadas extends AppCompatActivity {
    private TableLayout tabla;
    private ArrayList<Figura> figuras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones_realizadas);
        tabla = findViewById(R.id.tblOperaciones);
        figuras = Datos.obtener();

        for (int i =0; i<figuras.size(); i++){
            TableRow fila = new TableRow(this);

            TextView columna_uno = new TextView(this);
            TextView columna_dos = new TextView(this);
            TextView columna_tres =new TextView(this);
            TextView columna_cuatro = new TextView(this);

            columna_uno.setText("" + (i+1));
            columna_dos.setText(figuras.get(i).getOperacion());
            columna_tres.setText((figuras.get(i).getDato()));
            columna_cuatro.setText(figuras.get(i).getResultado());

            fila.addView(columna_uno);
            fila.addView(columna_dos);
            fila.addView(columna_tres);
            fila.addView(columna_cuatro);
        }
    }
}
