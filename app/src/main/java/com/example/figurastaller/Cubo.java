package com.example.figurastaller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

public class Cubo extends AppCompatActivity {
    private EditText lado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);

        lado = findViewById(R.id.txtLado);
    }

    public void limpiar(View v){
        lado.setText("");
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
    public void showResult(final View v){
        String Perfecto,nombreopCubo;
        double ladoCub, res=0;


        nombreopCubo=getString(R.string.nombreopcubo);
        if (validar()) {
            ladoCub = parseDouble(lado.getText().toString());

            res = ladoCub * ladoCub * ladoCub;

            String str_lado = String.valueOf(ladoCub);
            String str_resu = String.valueOf(res);
            Figura figura =new Figura(nombreopCubo, getString(R.string.radiotext)+" "+ str_lado, str_resu+" "+getString(R.string.centimentroscub));
            figura.guardar();
        }
        //resultado.setText(""+res);
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle(R.string.show_resultado);
        builder.setMessage(getString(R.string.result_volumen)+"  "+ res +" "+getString(R.string.centimentroscub));
        Perfecto=getString(R.string.opcion_listo);

        builder.setPositiveButton(Perfecto, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                limpiar(v);
                onBackPressed();
            }
        });
        AlertDialog dialog =builder.create();
        dialog.show();
    }

}
