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
        this.vue.getBtnJouer().addActionListener(e -> Jouer());

    }

    private void Jouer() {
        vue.getLabDeffinition().setVisible(true);
        vue.getLabelLettreSaisies().setVisible(true);
        vue.getLabelMotATrouver().setVisible(true);
        vue.getCbxModeDifficile().setVisible(false);

        model.genererMot();
        System.out.println(model.getMot().getMot());
        model.setJeuFini(false);
        model.resetNbEssais();
        model.videLettresSaisies();
        UpdateView();
        vue.getBtnJouer().setVisible(false);
        vue.requestFocusInWindow();
    }

    public PenduVue getVue(){
        return vue;
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        char keyChar = e.getKeyChar();

        if (!model.isJeuFini()){
            /** On vérifie que le mot n'a pas déjà été proposé que la touche appuyée est une lettre */
            if (!model.isMotPresent(keyChar) && Character.isLetter(keyChar)){
                /** On vérifiela lettre n'est pas dans le mot */
                if (model.getMot().getMot().contains(String.valueOf(keyChar))){
                    model.lettreTrouvee(keyChar);
                    if (model.getMotCache().getMot().equals(model.getMot().getMot())){
                        JeuFini();
                    }
                } else {
                    model.ajouterLettreSaisie(keyChar);
                    model.incrementNbEssais();
                    if (model.getNbEssais() >= 8){
                        JeuFini();
                    }
                }
                UpdateView();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    public void UpdateView(){
        vue.getLabelLettreSaisies().setText("Lettres proposés : " + model.getLettresSaisies());
        vue.getLabelMotATrouver().setText(model.getMotCache().getMot());
        vue.getLabDeffinition().setText(model.getMot().getDefinition());
        if (model.isJeuFini()){
            if (model.getMotCache().getMot().equals(model.getMot().getMot())){
                vue.getLabInfo().setText("Gagné !");
            } else{
                vue.getLabInfo().setText("Perdu ! le mot était : " + model.getMot().getMot());
                vue.getBtnJouer().setVisible(true);
            }
        } else {
            vue.getLabInfo().setText("Nombre d'essais : " + model.getNbEssais());
        }
    }

    public void JeuFini(){
        vue.getBtnJouer().setText("Rejouer");
        vue.getLabDeffinition().setVisible(false);
        vue.getLabelLettreSaisies().setVisible(false);
        vue.getLabelMotATrouver().setVisible(false);
        vue.getCbxModeDifficile().setVisible(true);
        vue.getBtnJouer().setVisible(true);
        model.setJeuFini(true);
    }
}
