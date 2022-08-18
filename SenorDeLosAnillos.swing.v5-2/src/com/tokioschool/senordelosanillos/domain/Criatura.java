package com.tokioschool.senordelosanillos.domain;

public abstract class Criatura {
    private String nombre;
    private int vida;
    private int armadura;

    public Criatura(String nombre, int vida, int armadura) {
        this.nombre = nombre;
        this.vida = vida;
        this.armadura = armadura;
    }

    public abstract int potenciaDeAtaque(Criatura criatura);

    public int danoProducido(int potenciaDeAtaque, Criatura enemigo) {
         return (potenciaDeAtaque - enemigo.getArmadura());
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getArmadura() {
        return armadura;
    }

    @Override
    public  String toString(){

        return getClass().getSimpleName();
    }
}
