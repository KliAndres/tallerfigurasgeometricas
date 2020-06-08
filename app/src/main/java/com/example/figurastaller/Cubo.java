package com.example.figurastaller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

public class Cubo extends AppCompatActivity {
    private EditText lado;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);

        lado = findViewById(R.id.txtLado);
        resultado = findViewById(R.id.lblResultado);
    }
    public void calcular(View v){
        double ladoCub, res=0;
        if (validar()) {
            ladoCub = parseDouble(lado.getText().toString());

            res = ladoCub * ladoCub * ladoCub;
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
