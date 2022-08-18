package com.tokioschool.senordelosanillos.views;

import com.tokioschool.senordelosanillos.domain.Criatura;
import fuentes.TitilliumWebBlack;
import fuentes.TitilliumWebRegular;

import javax.swing.*;
import java.awt.*;

public class EjercitoPanel extends JPanel {
    public JLabel lNombreDelEjercito;
    public CustomListModel ejercitoCriaturas;
    public JList<Criatura> jListaCriaturas;
    //public DefaultListModel<Criatura> modelo;
    public JScrollPane scrolllista;
    public JPanel buttonsPanel;
    public JButton upButton, downButton, deleteButton;
    private TitilliumWebRegular twr;
    private TitilliumWebBlack twb;


    public EjercitoPanel(String nombreDelEjercito, CustomListModel ejercitoCriaturas){
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.ejercitoCriaturas = ejercitoCriaturas;

        twr = new TitilliumWebRegular();
        twb = new TitilliumWebBlack();
        lNombreDelEjercito = new JLabel(nombreDelEjercito);
        lNombreDelEjercito.setFont(twb.MyFont(1, 18f));
        initComponents();

    }

    private void initComponents(){
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        upButton = new JButton("Subir");
        upButton.setActionCommand("up");
        downButton = new JButton("Bajar");
        downButton.setActionCommand("down");
        deleteButton = new JButton("Eliminar");
        deleteButton.setActionCommand("delete");
        buttonsPanel.add(upButton);
        buttonsPanel.add(downButton);
        buttonsPanel.add(deleteButton);

        jListaCriaturas = new JList<>();
        jListaCriaturas.setModel(ejercitoCriaturas);
        jListaCriaturas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrolllista = new JScrollPane();
        scrolllista.setViewportView(jListaCriaturas);
        scrolllista.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrolllista.setPreferredSize(new Dimension(80,80));

        add(lNombreDelEjercito);
        add(scrolllista);
        add(buttonsPanel);


    }



}
