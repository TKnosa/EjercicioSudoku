package com.tokioschool.senordelosanillos.util;

import java.util.Random;

public class Dado {
    Random dado = new Random();

    public static int lanzamiento(int potenciaMax){
        Random dado = new Random();
        int lanzamiento = dado.nextInt(potenciaMax + 1);
        return lanzamiento;
    }
}
