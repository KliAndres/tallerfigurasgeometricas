package com.example.figurastaller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

public class Esfera extends AppCompatActivity {
    private EditText radio;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esfera);

        radio = findViewById(R.id.txtLado);
        resultado = findViewById(R.id.lblResultado);
    }
    public void calcular(View v){
        double rad, res=0, pi=3.1415;
        if (validar()) {
            rad = parseDouble(radio.getText().toString());

            res = (4/3) * pi * rad * rad * rad;
        }
        resultado.setText(""+res);
    }
    public void limpiar(View v){
        radio.setText("");
        resultado.setText("");
    }
    public boolean validar(){
        String error_radio;
        int i=0;

        error_radio = getString(R.string.error_radio);

        if(radio.getText().toString().isEmpty()){
            radio.setError(error_radio);
            radio.requestFocus();
            return false;
        }
        return true;
    }

}
