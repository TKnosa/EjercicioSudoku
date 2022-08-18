package com.tokioschool.senordelosanillos.domain;

import java.util.ArrayList;

public class Bestias {
    ArrayList<Bestia> bestias;

    public void add(Bestia bestia){
        bestias.add(bestia);
    }
    public void delete(int i){
        bestias.remove(i);
    }
    
}
