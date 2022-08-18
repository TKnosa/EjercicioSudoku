package com.tokioschool.senordelosanillos.views;

import com.tokioschool.senordelosanillos.domain.Criatura;

import javax.swing.*;
import java.util.ArrayList;

public class CustomListModel extends AbstractListModel {

    //contendrá los cada uno de los componentes del ejercito.
    private ArrayList<Criatura> lista = new ArrayList<>();

    @Override
    public int getSize() {
        return lista.size();
    }

    // Esto es lo que imprimira el JList
    @Override
    public String getElementAt(int index) {
        Criatura criatura = lista.get(index);
        return (criatura.getNombre() + " - " + criatura.getClass().getSimpleName() + " (" + criatura.getVida() + ", " +
                criatura.getArmadura() + ")");
    }

    public void addCriatura(Criatura criatura){
        lista.add(criatura);
        this.fireIntervalAdded(this, getSize(), getSize() +1);
    }

    public void removeCriatura(int index0){
        lista.remove(index0);
        this.fireIntervalRemoved(index0, getSize(), getSize() + 1);
    }

    public Criatura getCriatura(int index){
        return lista.get(index);
    }

    public void goUpCriatura(int index){
        Criatura criatura = lista.get(index-1);
        lista.set(index-1, lista.get(index));
        lista.set(index, criatura);
        this.fireContentsChanged(this, getSize(), getSize()+1);
    }

    public void goDownCriatura(int index){
        Criatura criatura = lista.get(index+1);
        lista.set(index+1, lista.get(index));
        lista.set(index, criatura);
        this.fireContentsChanged(this, getSize(), getSize()+1);
    }

    public void actualizar(){
        this.fireContentsChanged(this, getSize(), getSize()+1);
    }

    public ArrayList<Criatura> getLista() {
        return lista;
    }

}
