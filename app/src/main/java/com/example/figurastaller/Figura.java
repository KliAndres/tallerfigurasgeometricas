package com.example.figurastaller;

public class Figura {
    private Double dato;
    private Double resultado;
    private String operacion;

    public Figura(String operacion, Double dato, double resultado){
        this.operacion = operacion;
        this.dato = dato;
        this.resultado = resultado;
    }

    public Double getDato() {return dato;}

    public void setDato(Double dato) {this.dato = dato;}

    public Double getResultado() {return resultado;}

    public void setResultado(Double resultado) {this.resultado = resultado;}

    public String getOperacion() {return operacion;}

    public void setOperacion(String operacion) {this.operacion = operacion;}

    public void guardar(){Datos.guardar(this);}
}

