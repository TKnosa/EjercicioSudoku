package com.tokioschool.senordelosanillos.domain;

public class Elfo extends Heroe{
    private int pistola;
    public Elfo(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

// metodo sobrescrito usando como base el metodo de la super clase
    @Override
    public int potenciaDeAtaque(Criatura criatura){
        if(!(criatura instanceof Orco))
            return super.potenciaDeAtaque(criatura);
        return super.potenciaDeAtaque(criatura) + 10;
    }
}
