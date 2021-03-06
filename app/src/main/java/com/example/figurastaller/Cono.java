package com.example.figurastaller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

public class Cono extends AppCompatActivity {
    public EditText radio, altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cono);

        radio = findViewById(R.id.txtLado);
        altura = findViewById(R.id.txtAltura);
    }

    public void limpiar(View v) {
        altura.setText("");
        radio.setText("");
    }

    public boolean validar() {
        String error_altura, error_radio;

        error_altura = getString(R.string.error_altura);
        error_radio = getString(R.string.error_radio);

        if (altura.getText().toString().isEmpty()) {
            altura.setError(error_altura);
            altura.requestFocus();
            return false;
        } else if (radio.getText().toString().isEmpty()) {
            radio.setError(error_radio);
            radio.requestFocus();
            return false;
        }
        return true;
    }

    public void showResult(final View v) {
        String Perfecto, nombreopCono;
        double Alt, rad, res = 0, pi = 3.1415;

        nombreopCono = getString(R.string.nombreopcono);
        if (validar()) {
            Alt = parseDouble(altura.getText().toString());
            rad = parseDouble(radio.getText().toString());
            res = (pi * rad * rad * Alt) / 3;

            String str_alt = String.valueOf(Alt);
            String str_rad = String.valueOf(rad);
            String str_resu = String.valueOf(res);
            Figura figura = new Figura(nombreopCono, getString(R.string.alturatext) + " " + str_alt + getString(R.string.radiotext) + " " + str_rad, str_resu + " " + getString(R.string.centimentroscub));
            figura.guardar();

            //resultado.setText(""+res);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.show_resultado);
            builder.setMessage(getString(R.string.result_volumen) + "  " + res + " " + getString(R.string.centimentroscub));
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
