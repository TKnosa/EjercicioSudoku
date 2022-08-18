package com.tokioschool.senordelosanillos.domain;

import com.tokioschool.senordelosanillos.util.Constantes;
import com.tokioschool.senordelosanillos.util.Dado;

public class Heroe extends Criatura{

    public Heroe(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    @Override
    public int potenciaDeAtaque(Criatura criatura){
        int  dado = 0;
        int tirada;
        for(int i = 0; i < Constantes.NRO_TIRADAS_HEROE; i++) {
            tirada = Dado.lanzamiento(Constantes.POTENCIA_MAX_HEROE);
            if (tirada > dado)
                dado = tirada;
        }
        return dado;
    }
}
