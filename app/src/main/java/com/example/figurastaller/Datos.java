package com.example.figurastaller;

import java.util.ArrayList;

public class Datos {
    private static ArrayList<Figura> figuras = new ArrayList();

    public static void guardar(Figura f){figuras.add(f);}
    public static ArrayList<Figura> obtener(){return figuras;}
}
