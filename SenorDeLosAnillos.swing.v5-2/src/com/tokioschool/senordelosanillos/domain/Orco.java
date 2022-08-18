package com.tokioschool.senordelosanillos.domain;

public class Orco extends Bestia{

    public Orco(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    // supongo valores de escudo multiplos de 10, para mantener int
    @Override
    public int danoProducido(int potenciaDeAtaque, Criatura enemigo){
        int disminucionEscudo = (int) (enemigo.getArmadura()*0.1);
        return super.danoProducido(potenciaDeAtaque, enemigo) + disminucionEscudo;
    }

}
