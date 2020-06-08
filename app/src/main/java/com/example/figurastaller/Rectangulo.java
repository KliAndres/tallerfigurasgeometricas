package com.example.figurastaller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

public class Rectangulo extends AppCompatActivity {
    public EditText base, altura;
    public TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        base = findViewById(R.id.txtBase);
        altura = findViewById(R.id.txtAltura);
        resultado = findViewById(R.id.lblResultado);
    }
    public void calcular(View v){
        double Alt, bas, res=0;
        if (validar()) {
            Alt = parseDouble(altura.getText().toString());
            bas = parseDouble(base.getText().toString());
            res = Alt * bas;
        }
        resultado.setText(""+res);
    }
    public void limpiar(View v){
        altura.setText("");
        base.setText("");
        resultado.setText("");
    }
    public boolean validar(){
        String error_altura, error_base;

        error_altura = getString(R.string.error_altura);
        error_base = getString(R.string.error_base);

        if(altura.getText().toString().isEmpty()){
            altura.setError(error_altura);
            altura.requestFocus();
            return false;
        }else if(base.getText().toString().isEmpty()){
            base.setError(error_base);
            base.requestFocus();
            return false;
        }
        return true;
    }

}
