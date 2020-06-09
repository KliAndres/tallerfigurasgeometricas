package com.example.figurastaller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

public class Triangulo extends AppCompatActivity {
    public EditText base, altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);

        base = findViewById(R.id.txtBase);
        altura = findViewById(R.id.txtAltura);
    }

    public void limpiar(View v) {
        altura.setText("");
        base.setText("");
    }

    public boolean validar() {
        String error_altura, error_base;

        error_altura = getString(R.string.error_altura);
        error_base = getString(R.string.error_base);

        if (altura.getText().toString().isEmpty()) {
            altura.setError(error_altura);
            altura.requestFocus();
            return false;
        } else if (base.getText().toString().isEmpty()) {
            base.setError(error_base);
            base.requestFocus();
            return false;
        }
        return true;
    }

    public void showResult(final View v) {
        String Perfecto;
        double Alt, bas, res = 0;
        if (validar()) {
            Alt = parseDouble(altura.getText().toString());
            bas = parseDouble(base.getText().toString());

            res = (Alt * bas) / 2;
        }
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