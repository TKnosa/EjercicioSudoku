package com.tokioschool.senordelosanillos.domain;

public class Hobbit extends Heroe{

    public Hobbit(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    @Override
    public int potenciaDeAtaque(Criatura criatura){
        if(!(criatura instanceof Trasgo))
            return super.potenciaDeAtaque(criatura);
        int potenciaDeAtaque = super.potenciaDeAtaque(criatura) - 5;
        if(potenciaDeAtaque >0)
            return potenciaDeAtaque;
        return 0;
    }
}
