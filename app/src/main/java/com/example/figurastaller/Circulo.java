package com.example.figurastaller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

public class Circulo extends AppCompatActivity {
    private EditText radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);

        radio = findViewById(R.id.txtLado);
    }

    public void limpiar(View v){
        radio.setText("");
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
    public void showResult(final View v) {
        String Perfecto, nombreopCirc;
        double rad, res = 0, pi = 3.1415;

        nombreopCirc = getString(R.string.nombreopcir);
        if (validar()) {
            rad = parseDouble(radio.getText().toString());

            res = 2 * pi * rad * rad;

            String str_rad = String.valueOf(rad);
            String str_resu = String.valueOf(res);
            Figura figura = new Figura(nombreopCirc, getString(R.string.radiotext) + " " + str_rad, str_resu + " " + getString(R.string.centimentros));
            figura.guardar();

            //resultado.setText(""+res);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.show_resultado);
            builder.setMessage(getString(R.string.result_area) + "  " + res + " " + getString(R.string.centimentros));
            Perfecto = getString(R.string.opcion_listo);

            builder.setPositiveButton(Perfecto, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    limpiar(v);
                    onBackPressed();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

}
