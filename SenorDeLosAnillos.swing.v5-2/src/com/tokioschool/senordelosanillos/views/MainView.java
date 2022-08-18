package com.tokioschool.senordelosanillos.views;

import com.tokioschool.senordelosanillos.controller.BatallaPanelController;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    CustomListModel ejercitoHeroes = new CustomListModel();
    CustomListModel ejercitoBestias = new CustomListModel();

    DatosPanel datosPanel;
    EjercitosPanel ejercitosPanel;
    BatallaPanel batallaPanel;

    BatallaPanelController batallaPanelController;

    public MainView(){
        super();
        initComponents();
        cofigureJFrame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initComponents(){
        this.setTitle("Batalla por la Tierra Media");
        setLayout(new BorderLayout(20,20));
        datosPanel = new DatosPanel(ejercitoHeroes, ejercitoBestias);
        ejercitosPanel = new EjercitosPanel(ejercitoHeroes, ejercitoBestias);
        batallaPanel = new BatallaPanel(ejercitoHeroes, ejercitoBestias);
        batallaPanelController = new BatallaPanelController(batallaPanel);

        getContentPane().add(datosPanel, BorderLayout.NORTH);
        getContentPane().add(ejercitosPanel, BorderLayout.CENTER);
        getContentPane().add(batallaPanel, BorderLayout.SOUTH);
    }

    private void cofigureJFrame(){
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
