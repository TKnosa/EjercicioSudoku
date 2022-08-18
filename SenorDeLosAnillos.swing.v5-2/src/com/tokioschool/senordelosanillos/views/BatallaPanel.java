package com.tokioschool.senordelosanillos.views;

import fuentes.TitilliumWebBlack;
import fuentes.TitilliumWebRegular;

import javax.swing.*;
import javax.swing.text.DefaultCaret;


public class BatallaPanel extends JPanel {

    public JButton fightButton;
    public JTextArea consola;
    private JScrollPane scrollTextArea;
    private DefaultCaret caret;
    public CustomListModel ejercitoHeroes, ejercitoBestias;

    private TitilliumWebBlack twb;
    private TitilliumWebRegular twr;

    public BatallaPanel(CustomListModel ejercitoHeroes, CustomListModel ejercitoBestias){
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.ejercitoHeroes = ejercitoHeroes;
        this.ejercitoBestias = ejercitoBestias;
        initComponentes();
    }

    private void initComponentes(){
        twb = new TitilliumWebBlack();
        twr = new TitilliumWebRegular();
        fightButton = new JButton("A Luchar!");
        fightButton.setFont(twr.MyFont(1,16));
        fightButton.setAlignmentX(CENTER_ALIGNMENT);
        fightButton.setActionCommand("fight");

        consola = new JTextArea(6, 50);
        consola.setFont(twr.MyFont(0,16));
        caret = (DefaultCaret) consola.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        mensajeInincial();
        scrollTextArea = new JScrollPane(consola, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        add(Box.createVerticalStrut(10));
        add(fightButton);
        add(Box.createVerticalStrut(5));
        add(scrollTextArea);
    }
    private void mensajeInincial() {
        consola.setText("Para empezar a jugar agregue guerreros en los respectivos ejercitos" + '\n');
        consola.append("Asigne un nombre a su luchador" + '\n');
        consola.append("Seleccione el tipo de criatura" + '\n');
        consola.append("Asigne la vida, un numero entero positivo entre 0 y 201" + '\n');
        consola.append("Asigne al escudo uno de estos valores (0, 10, 20, 30, 40, 50 o 60)" + '\n');
        consola.append("Presione el botón de AGREGAR" + '\n');
    }
}
