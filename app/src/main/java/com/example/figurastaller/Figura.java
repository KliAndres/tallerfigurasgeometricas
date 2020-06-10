package com.example.figurastaller;

public class Figura {
    private String dato;
    private String  resultado;
    private String operacion;

    public Figura(String operacion, String  dato, String  resultado){
        this.operacion = operacion;
        this.dato = dato;
        this.resultado = resultado;
    }

    public String getDato() {return dato;}

    public void setDato(String dato) {this.dato = dato;}

    public String getResultado() {return resultado;}

    public void setResultado(String resultado) {this.resultado = resultado;}

    public String getOperacion() {return operacion;}

    public void setOperacion(String operacion) {this.operacion = operacion;}

    public void guardar(){Datos.guardar(this);}
}

