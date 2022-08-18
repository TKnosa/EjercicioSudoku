package com.tokioschool.senordelosanillos.views;

import com.tokioschool.senordelosanillos.controller.DataCriaturaController;
import com.tokioschool.senordelosanillos.util.Constantes;

import javax.swing.*;


public class DatosPanel extends JPanel {
    CriaturaDataPanel heroeDataPanel, bestiaDataPanel;
    DataCriaturaController heroeDataPanelController, bestiaDataPanelController;
    CustomListModel ejercitoHeroes, ejercitoBestias;

    public DatosPanel(CustomListModel ejercitoHeroes, CustomListModel ejercitoBestias){
        super();
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.ejercitoHeroes = ejercitoHeroes;
        this.ejercitoBestias = ejercitoBestias;
        initComponents();
    }

    private void initComponents(){
        heroeDataPanel = new CriaturaDataPanel(Constantes.CLASES_HEROES, ejercitoHeroes, "Heroes");
        heroeDataPanelController = new DataCriaturaController(heroeDataPanel);
        bestiaDataPanel = new CriaturaDataPanel(Constantes.CLASES_BESTIAS, ejercitoBestias, "Bestias");
        bestiaDataPanelController = new DataCriaturaController(bestiaDataPanel);

       add(heroeDataPanel);
       add(Box.createHorizontalStrut(5));
       add(bestiaDataPanel);

    }

}
