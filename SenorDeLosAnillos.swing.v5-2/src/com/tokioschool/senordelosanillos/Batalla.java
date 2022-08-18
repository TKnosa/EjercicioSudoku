package com.tokioschool.senordelosanillos;

import com.tokioschool.senordelosanillos.domain.Bestia;
import com.tokioschool.senordelosanillos.domain.Criatura;
import com.tokioschool.senordelosanillos.domain.Heroe;
import com.tokioschool.senordelosanillos.views.BatallaPanel;

import java.util.ArrayList;
import java.util.List;

public class Batalla {
    private List<Criatura> heroes;
    private List<Criatura> bestias;
    private List<Criatura> criaturas;
    private BatallaPanel batallaPanel;
    private int turno = 1; // contador de entrentamientos

    public Batalla(List<Criatura> heroes, List<Criatura> bestias, BatallaPanel batallaPanel) {
        this.heroes = heroes;
        this.bestias = bestias;
        this.batallaPanel = batallaPanel;
        criaturas = new ArrayList<>(); // creado solo con el objeto de revisar de una sola vez la vida de los 2 ejercito
        aLaGuerra();
    }

    // todo revisar que algun array no esté vacio
    public void aLaGuerra(){
        boolean fin = false;
        criaturas = criaturasVivas();
        do{
            turno();
            limpieza(criaturas); // enterramos a los caidos
            fin = revisionBatalla();

        }while(!fin);
    }

    public List<Criatura> criaturasVivas(){
        criaturas.addAll(heroes);
        criaturas.addAll(bestias);
        return criaturas;
    }

    public void turno(){
        int numeroDeEnfrentamientos = (heroes.size() < bestias.size())? heroes.size(): bestias.size();
        int vida;
        batallaPanel.consola.append("Turno " + turno++ + ":" + '\n');
        for(int i = 0; i < numeroDeEnfrentamientos; i++){
            imprimirLuchadores(i);
            bestias.get(i).setVida(new Lucha(heroes.get(i), bestias.get(i), batallaPanel).enfrentamiento());
            heroes.get(i).setVida(new Lucha(bestias.get(i), heroes.get(i), batallaPanel).enfrentamiento());
            // verificar salud de las criaturas
            algunFallecido(heroes.get(i), bestias.get(i));
        }
    }

    public void limpieza(List<Criatura> criaturas) {
        for(Criatura criatura : criaturas){
            if(criatura.getVida() <= 0){
                if(criatura instanceof Heroe)
                    heroes.remove(criatura);

                if(criatura instanceof Bestia)
                    bestias.remove(criatura);
            }
            // con esto se actualiza el panel del ejercito
            batallaPanel.ejercitoHeroes.actualizar();
            batallaPanel.ejercitoBestias.actualizar();
        }
        criaturas.removeAll(criaturas); //quitamos todas las criaturas
        criaturas = criaturasVivas(); // actualizamos con las vivas
    }

    public boolean revisionBatalla(){
        if( heroes.size() > 0 && bestias.size() > 0)
            return false; // la batalla continua
        if (heroes.size() > 0){
            batallaPanel.consola.append("VICTORIA DE LOS HEROES !!!" + '\n');
        }else {
            batallaPanel.consola.append(("VICTORIA DE LAS BESTIAS !!!" + '\n'));
        }
        return true; // fin de la batalla
    }

    public void algunFallecido(Criatura criatura1, Criatura criatura2){
        if (!(criatura1.getVida() > 0))
            imprimirFallecido(criatura1);
        if(!(criatura2.getVida() > 0))
            imprimirFallecido(criatura2);
    }

    public void imprimirLuchadores(int i){
        batallaPanel.consola.append("  Lucha entre ");
        batallaPanel.consola.append(heroes.get(i).getNombre() + "(" + "Vida=" + heroes.get(i).getVida());
        batallaPanel.consola.append(" Armadura=" + heroes.get(i).getArmadura() + ") y ");
        batallaPanel.consola.append(bestias.get(i).getNombre() + "(" + "Vida=" + bestias.get(i).getVida());
        batallaPanel.consola.append(" Armadura=" + bestias.get(i).getArmadura() + ")" + '\n');
    }

    public void imprimirParcial(Criatura criatura1, Criatura criatura2, int potencia, int quita){
        batallaPanel.consola.append("    " + criatura1.getNombre() + " saca " + potencia);
        batallaPanel.consola.append(" y le quita " + quita + " de vida a " + criatura2.getNombre() + '\n');
    }

    public void imprimirFallecido(Criatura criatura){
        batallaPanel.consola.append("  Muere " + criatura.getClass().getSimpleName() + " " + criatura.getNombre() + '\n');
    }

}
