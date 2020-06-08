package com.example.figurastaller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

public class Cuadrado extends AppCompatActivity {
    private EditText lado;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);

        lado = findViewById(R.id.txtLado);
        resultado = findViewById(R.id.lblResultado);
    }
    public void calcular(View v){
        double ladoRec, res=0;
        if (validar()) {
            ladoRec = parseDouble(lado.getText().toString());

            res = ladoRec * ladoRec;
        }
        resultado.setText(""+res);
    }
    public void limpiar(View v){
        lado.setText("");
        resultado.setText("");
    }
    public boolean validar(){
        String error_lado;
        int i=0;

        error_lado = getString(R.string.error_lado);

        if(lado.getText().toString().isEmpty()){
            lado.setError(error_lado);
            lado.requestFocus();
            return false;
        }
    return true;
    }

}
