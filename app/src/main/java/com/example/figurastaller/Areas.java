package com.example.figurastaller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Areas extends AppCompatActivity {
    private ListView lista_figuras;
    private String[] figurasPlanas;
    private ArrayAdapter<String> adapter_areas;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);

        lista_figuras=findViewById(R.id.lstAreas);
        figurasPlanas= getResources().getStringArray(R.array.figurasPlanas);
        adapter_areas=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, figurasPlanas);
        lista_figuras.setAdapter(adapter_areas);
        lista_figuras.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent=new Intent(Areas.this, Cuadrado.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent=new Intent(Areas.this, Rectangulo.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent=new Intent(Areas.this, Triangulo.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent=new Intent(Areas.this, Circulo.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
