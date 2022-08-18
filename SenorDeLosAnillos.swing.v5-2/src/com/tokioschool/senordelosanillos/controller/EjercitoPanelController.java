package com.tokioschool.senordelosanillos.controller;

import com.tokioschool.senordelosanillos.views.EjercitoPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercitoPanelController implements ActionListener {
    EjercitoPanel ejercitoPanel;

    public EjercitoPanelController(EjercitoPanel ejercitoPanel){
        this.ejercitoPanel = ejercitoPanel;
        addListeners();
    }

    private void addListeners(){
        ejercitoPanel.upButton.addActionListener(this);
        ejercitoPanel.downButton.addActionListener(this);
        ejercitoPanel.deleteButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand){
            case "up":
                doUp();
                break;
            case "down":
                doDown();
                break;
            case "delete":
                doDelete();
                break;
        }
    }
    private void doDelete(){
        int selection = ejercitoPanel.jListaCriaturas.getSelectedIndex();
        if(selection!= -1){
            ejercitoPanel.ejercitoCriaturas.removeCriatura(selection);
        }
    }
    private void doUp(){
        int selection = ejercitoPanel.jListaCriaturas.getSelectedIndex();
        if(selection != -1){
            if(selection != 0){
                ejercitoPanel.ejercitoCriaturas.goUpCriatura(selection);
            }
        }
    }

    private void doDown(){
        int selection = ejercitoPanel.jListaCriaturas.getSelectedIndex();
            if(selection != -1) {
                if (selection != ejercitoPanel.ejercitoCriaturas.getSize() - 1){
                    ejercitoPanel.ejercitoCriaturas.goDownCriatura(selection);
                }
            }
    }
}
