package com.tokioschool.senordelosanillos;

import com.tokioschool.senordelosanillos.domain.*;
import com.tokioschool.senordelosanillos.views.BatallaPanel;

public class Lucha {
    private Criatura criatura1;
    private Criatura criatura2;
    private BatallaPanel batallaPanel;

    public Lucha(Criatura criatura1, Criatura criatura2, BatallaPanel batallaPanel){
        this.criatura1 = criatura1;
        this.criatura2 = criatura2;
        this.batallaPanel = batallaPanel;
    }

    public int enfrentamiento(){
        int potencia = criatura1.potenciaDeAtaque(criatura2);
        int quita = criatura1.danoProducido(potencia, criatura2);
        if (quita < 0)
            quita = 0;

        imprimirParcial(criatura1, criatura2, potencia, quita);
        return criatura2.getVida() - quita;
    }

    public void imprimirParcial(Criatura criatura1, Criatura criatura2, int potencia, int quita){
        batallaPanel.consola.append("    " + criatura1.getNombre() + " saca " + potencia);
        batallaPanel.consola.append(" y le quita " + quita + " de vida a " + criatura2.getNombre() + '\n');
    }

}
