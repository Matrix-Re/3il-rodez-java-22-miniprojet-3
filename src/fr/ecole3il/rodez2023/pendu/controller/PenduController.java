package fr.ecole3il.rodez2023.pendu.controller;

import fr.ecole3il.rodez2023.pendu.model.PenduModel;
import fr.ecole3il.rodez2023.pendu.view.PenduVue;

import javax.swing.*;

public class PenduController {

    PenduModel model;
    PenduVue vue;
    JButton button;

    public PenduController(PenduModel model, PenduVue vue, JButton button){
        this.model = model;
        this.vue = vue;
        this.button = button;
        //this.button.addActionListener(e -> OuvrirSelecteurCouleur());
    }

    public PenduVue getVue(){
        return vue;
    }
}
