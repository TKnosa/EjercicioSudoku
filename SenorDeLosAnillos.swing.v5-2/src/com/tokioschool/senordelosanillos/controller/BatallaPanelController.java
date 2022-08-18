package com.tokioschool.senordelosanillos.controller;

import com.tokioschool.senordelosanillos.Batalla;
import com.tokioschool.senordelosanillos.domain.Criatura;
import com.tokioschool.senordelosanillos.views.BatallaPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BatallaPanelController implements ActionListener {
    private BatallaPanel batallaPanel;

    public BatallaPanelController(BatallaPanel batallaPanel){
        this.batallaPanel = batallaPanel;
        addListeners();
    }

    private void addListeners(){
        batallaPanel.fightButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch(actionCommand){
            case "fight":
                crearBatalla();
        }
    }

    private void crearBatalla(){
        List<Criatura> heroes = batallaPanel.ejercitoHeroes.getLista();
        List<Criatura> bestias = batallaPanel.ejercitoBestias.getLista();
        if(heroes.size() != 0 && bestias.size() != 0) {
            batallaPanel.consola.setText("");
            Batalla batalla = new Batalla(heroes, bestias, batallaPanel);
        } else {
            JOptionPane.showMessageDialog(null, "Cada ejercito debe tener al menos un guerrero","Preparacion de Ejercitos", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
