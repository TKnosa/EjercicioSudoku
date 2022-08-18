package com.tokioschool.senordelosanillos.controller;

import com.tokioschool.senordelosanillos.domain.*;
import com.tokioschool.senordelosanillos.views.CriaturaDataPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataCriaturaController implements ActionListener {

    CriaturaDataPanel criaturaDataPanel;

    public DataCriaturaController(CriaturaDataPanel criaturaDataPanel){
        this.criaturaDataPanel = criaturaDataPanel;
        addListners();
    }

    private void addListners(){
        criaturaDataPanel.addButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand){
            case "add":
                addCriatura();
                break;
        }
    }

    private void addCriatura(){
        Criatura criatura;
        // Nombre del Guerrero y verificación del dato
        String name = criaturaDataPanel.nombreSoldado.getText();
        name = name.trim();
        if(!checkText(name))
            return;

        int vidaInicial;
        try{
            vidaInicial = checkInteger(criaturaDataPanel.vidaInicial.getText());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "La Vida del guerrero debe ser un numero entero, entre 0 y 201", "Vida "
                    + "del Gerrero", JOptionPane.INFORMATION_MESSAGE);
            criaturaDataPanel.vidaInicial.setText("");
            return;
        }

        String clase = (String)criaturaDataPanel.tipoSoldado.getSelectedItem();

        int armaduraInicial =criaturaDataPanel.armaduraInicial.getValue();


        switch(clase){
            case"Elfo":
                criatura = new Elfo(name,vidaInicial,armaduraInicial);
                break;
            case "Hobbit":
                criatura = new Hobbit(name,vidaInicial,armaduraInicial);
                break;
            case "Humano":
                criatura = new Humano(name, vidaInicial,armaduraInicial);
                break;
            case "Orco":
                criatura = new Orco(name, vidaInicial, armaduraInicial);
                break;
            case "Trasgo":
                criatura = new Trasgo(name, vidaInicial, armaduraInicial);
                break;
            default: criatura = null; // siempre va a tener un valor
        }
        criaturaDataPanel.luchadoresEjercito.addCriatura(criatura);
        clearData();
    }

    private void clearData(){
        criaturaDataPanel.nombreSoldado.setText("");
        criaturaDataPanel.vidaInicial.setText("");
        criaturaDataPanel.armaduraInicial.setValue(30);
    }


    private boolean checkText(String texto){
        if(texto.length() == 0){
            JOptionPane.showMessageDialog(null, "El Guerrero debe tener un nombre", "Nombre del Gerrero", JOptionPane.INFORMATION_MESSAGE);
            criaturaDataPanel.nombreSoldado.setText("");
            return false;
        }
        return true;
    }

    private int checkInteger(String vida) throws Exception{
        // el error de un numero negativo lo corrijo automaticamente.
            int vidaInicial = Math.abs(Integer.parseInt(criaturaDataPanel.vidaInicial.getText()));
            if (!(vidaInicial > 0 && vidaInicial < 201)) // en caso de que fuera negativo pero en rango, lo convierto.
                throw new Exception();
            return vidaInicial;
    }

}
