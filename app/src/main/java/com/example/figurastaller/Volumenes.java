package com.example.figurastaller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Volumenes extends AppCompatActivity {
    private ListView lista_volumen;
    private String[] figuras;
    private ArrayAdapter<String> adapter_Volumen;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumenes);

        lista_volumen=findViewById(R.id.lstVolumenes);
        figuras=getResources().getStringArray(R.array.opciones);
        adapter_Volumen=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, figuras);
        lista_volumen.setAdapter(adapter_Volumen);
        lista_volumen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent=new Intent(Volumenes.this,Esfera.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent= new Intent(Volumenes.this, Cilindro.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent=new Intent(Volumenes.this,Cono.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent=new Intent(Volumenes.this, Cubo.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
