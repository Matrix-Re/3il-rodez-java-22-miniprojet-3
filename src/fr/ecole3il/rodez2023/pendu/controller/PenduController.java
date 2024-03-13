package fr.ecole3il.rodez2023.pendu.controller;

import fr.ecole3il.rodez2023.pendu.model.PenduModel;
import fr.ecole3il.rodez2023.pendu.view.PenduVue;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PenduController implements KeyListener {

    PenduModel model;
    PenduVue vue;

    public PenduController(PenduModel model, PenduVue vue){
        this.model = model;
        this.vue = vue;
        this.vue.addKeyListener(this);

        model.genererMot();
        System.out.println(model.getMot().getMot());

        UpdateView();
    }

    public PenduVue getVue(){
        return vue;
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        char keyChar = e.getKeyChar();

        // On vérifie que le mot n'a pas déjà été proposé et que la touche appuyée est une lettre
        if (!model.isMotPresent(keyChar) && Character.isLetter(keyChar)) {
            model.ajouterLettreSaisie(e.getKeyChar());
            UpdateView();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    public void UpdateView(){
        vue.getLabel().setText("Lettres proposés : " + model.getLettresSaisies());
        vue.getLabel().setText(model.getMotCache().getMot());
    }
}
