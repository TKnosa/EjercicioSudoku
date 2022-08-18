package com.tokioschool.senordelosanillos.views;

import com.tokioschool.senordelosanillos.controller.EjercitoPanelController;
import com.tokioschool.senordelosanillos.util.Constantes;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class EjercitosPanel extends JPanel {
    EjercitoPanel heroesEjercitoPanel, bestiasEjercitoPanel;
    EjercitoPanelController heroesPanelController, bestiasPanelController;
    CustomListModel ejercitoHeroes, ejercitoBestias;

    public EjercitosPanel(CustomListModel ejercitoHeroes, CustomListModel ejercitoBestias){
        super();
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(LineBorder.createBlackLineBorder());
        this.ejercitoHeroes = ejercitoHeroes;
        this.ejercitoBestias = ejercitoBestias;
        initComponents();
    }

    private void initComponents(){
        heroesEjercitoPanel = new EjercitoPanel("Heroes", ejercitoHeroes);
        heroesPanelController = new EjercitoPanelController(heroesEjercitoPanel);
        bestiasEjercitoPanel = new EjercitoPanel("Bestias", ejercitoBestias);
        bestiasPanelController= new EjercitoPanelController(bestiasEjercitoPanel);
        add(heroesEjercitoPanel);
        add(bestiasEjercitoPanel);

    }
}
