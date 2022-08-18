package com.tokioschool.senordelosanillos.views;

import fuentes.TitilliumWebBlack;
import fuentes.TitilliumWebRegular;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CriaturaDataPanel extends JPanel {
    JLabel lNombreEjercito;
    public JPanel datosSoldado;
    public JTextField nombreSoldado, vidaInicial;
    public JSlider armaduraInicial;
    public JComboBox<String> tipoSoldado;
    public JButton addButton;
    String[] criaturasArray;
    public CustomListModel luchadoresEjercito;
    private TitilliumWebBlack twb;
    private TitilliumWebRegular twr;

    public CriaturaDataPanel(String[] criaturasArray,CustomListModel luchadoresEjercito, String nombreEjercito){
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LineBorder.createBlackLineBorder());
        this.criaturasArray = criaturasArray;
        this.luchadoresEjercito = luchadoresEjercito;
        twb = new TitilliumWebBlack();
        twr = new TitilliumWebRegular();
        lNombreEjercito = new JLabel(nombreEjercito);
        lNombreEjercito.setFont(twb.MyFont(1, 18f));

        initComponentes();


    }

    private void initComponentes(){
        twr = new TitilliumWebRegular();
        datosSoldado = new JPanel();
        datosSoldado.setLayout( new GridLayout(4,2));
        JLabel nombre = new JLabel(" Nombre:");
        nombreSoldado = new JTextField(8);
        JLabel tipo = new JLabel(" Tipo:");

        tipoSoldado = new JComboBox<>();
        for(String tipoCriatura: criaturasArray){
            tipoSoldado.addItem(tipoCriatura);
        }

        JLabel vida = new JLabel(" Vida:");
        vidaInicial = new JTextField(8);
        JLabel armadura = new JLabel(" Armadura:");
        armaduraInicial = new JSlider(0,60,30);
        armaduraInicial.setMinorTickSpacing(10);
        armaduraInicial.setMajorTickSpacing(10);
        armaduraInicial.setSnapToTicks(true);
        armaduraInicial.setPaintTicks(true);
        armaduraInicial.setPaintLabels(true);
        datosSoldado.add(nombre);
        datosSoldado.add(nombreSoldado);
        datosSoldado.add(tipo);
        datosSoldado.add(tipoSoldado);
        datosSoldado.add(vida);
        datosSoldado.add(vidaInicial);
        datosSoldado.add(armadura);
        datosSoldado.add(armaduraInicial);

        addButton = new JButton("Añadir");
        addButton.setFont(twr.MyFont(1, 14f));
        addButton.setActionCommand("add");

        add(lNombreEjercito);
        add(datosSoldado);
        add(Box.createVerticalStrut(5));
        add(addButton);
        add(Box.createVerticalStrut(10));

    }
}
