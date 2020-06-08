package com.example.figurastaller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

public class Circulo extends AppCompatActivity {
    private EditText radio;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);

        radio = findViewById(R.id.txtRadio);
        resultado = findViewById(R.id.lblResultado);
    }
    public void calcular(View v){
        double rad, res=0;
        if (validar()) {
            rad = parseDouble(radio.getText().toString());

            res = 2 * (3.1416) * rad * rad;
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

        error_radio = "Error, debe ingresar el radio";

        if(radio.getText().toString().isEmpty()){
            radio.setError(error_radio);
            radio.requestFocus();
            return false;
        }
        return true;
    }

}
