package com.tokioschool.senordelosanillos.domain;

import com.tokioschool.senordelosanillos.util.Constantes;
import com.tokioschool.senordelosanillos.util.Dado;

public class Bestia extends Criatura{
    public Bestia(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    @Override
    public int potenciaDeAtaque(Criatura criatura) {
        return Dado.lanzamiento(Constantes.POTENCIA_MAX_BESTIA);
    }
}
