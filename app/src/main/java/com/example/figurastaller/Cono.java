package com.example.figurastaller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

public class Cono extends AppCompatActivity {
    public EditText radio, altura;
    public TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cono);

        radio = findViewById(R.id.txtLado);
        altura = findViewById(R.id.txtAltura);
        resultado = findViewById(R.id.lblResultado);
    }
    public void calcular(View v){
        double Alt, rad, res=0, pi=3.1415;
        if (validar()) {
            Alt = parseDouble(altura.getText().toString());
            rad = parseDouble(radio.getText().toString());
            res = (pi * rad * rad * Alt)/3;
        }
        resultado.setText(""+res);
    }
    public void limpiar(View v){
        altura.setText("");
        radio.setText("");
        resultado.setText("");
    }
    public boolean validar(){
        String error_altura, error_radio;

        error_altura = getString(R.string.error_altura);
        error_radio = getString(R.string.error_radio);

        if(altura.getText().toString().isEmpty()){
            altura.setError(error_altura);
            altura.requestFocus();
            return false;
        }else if(radio.getText().toString().isEmpty()){
            radio.setError(error_radio);
            radio.requestFocus();
            return false;
        }
        return true;
    }

}
