package fr.ecole3il.rodez2023.pendu.controller;

import fr.ecole3il.rodez2023.pendu.model.PenduModel;
import fr.ecole3il.rodez2023.pendu.view.PenduVue;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PenduController implements KeyListener {

    PenduModel model;
    PenduVue vue;

    public PenduController(PenduModel model, PenduVue vue){
        this.model = model;
        this.vue = vue;

        this.vue.addKeyListener(this);
        //this.button.addActionListener(e -> OuvrirSelecteurCouleur());
    }

    public PenduVue getVue(){
        return vue;
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!model.isMotPresent(e.getKeyChar())) {
            model.ajouterMotSaisies(e.getKeyChar());
            vue.getLabel().setText(model.getMotsSaisies());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}
