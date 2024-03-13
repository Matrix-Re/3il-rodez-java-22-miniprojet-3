package fr.ecole3il.rodez2023.pendu.view;

import fr.ecole3il.rodez2023.pendu.model.PenduModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Classe PenduVue qui représente la vue du jeu du pendu.
 */
public class PenduVue extends JFrame implements MouseMotionListener {

    /**
     * Modèle du jeu du pendu.
     */
    private PenduModel Dm;

    /**
     * Fenêtre principale du jeu.
     */
    private JFrame fen = this;

    /**
     * Label pour afficher les lettres saisies par le joueur.
     */
    private JLabel labLettresSaisies;

    /**
     * Label pour afficher le mot à trouver.
     */
    private JLabel labMotATrouver;

    /**
     * Label pour afficher la définition du mot.
     */
    private JLabel labDeffinition;

    /**
     * Label pour afficher les informations du jeu.
     */
    private JLabel labInfo;

    /**
     * Label pour afficher le temps restant.
     */
    private JLabel labTempsRestant;

    /**
     * Bouton pour démarrer le jeu.
     */
    private JButton btnJouer;

    /**
     * Case à cocher pour activer le mode difficile.
     */
    private JCheckBox cbxModeDifficile;

    /**
     * Constructeur de PenduVue.
     * @param Dm Modèle du jeu du pendu.
     */
    public PenduVue(PenduModel Dm){
        this.Dm = Dm;
        labLettresSaisies = new JLabel();
        labMotATrouver = new JLabel();
        labDeffinition = new JLabel();
        labInfo = new JLabel();
        labTempsRestant = new JLabel();
        btnJouer = new JButton("Jouer");
        cbxModeDifficile = new JCheckBox("Mode difficile");

        labDeffinition.setVisible(false);
        labLettresSaisies.setVisible(false);
        labMotATrouver.setVisible(false);
        labTempsRestant.setVisible(false);

        fen.setTitle("Pendu");
        fen.setLayout(new GridLayout(2, 1));
        fen.setBackground(Color.white);
        fen.setSize(400, 300);
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fen.setVisible(true);

        fen.add(labLettresSaisies);
        fen.add(labMotATrouver);
        fen.add(labDeffinition);
        fen.add(labInfo);
        fen.add(labTempsRestant);
        fen.add(btnJouer);
        fen.add(cbxModeDifficile);

        addMouseMotionListener(this);
    }

    /**
     * Retourne le label pour les lettres saisies.
     * @return Le label pour les lettres saisies.
     */
    public JLabel getLabelLettreSaisies() {
        return labLettresSaisies;
    }

    /**
     * Retourne le label pour le mot à trouver.
     * @return Le label pour le mot à trouver.
     */
    public JLabel getLabelMotATrouver() {
        return labMotATrouver;
    }

    /**
     * Retourne le label pour la définition du mot.
     * @return Le label pour la définition du mot.
     */
    public JLabel getLabDeffinition() {
        return labDeffinition;
    }

    /**
     * Retourne le label pour les informations du jeu.
     * @return Le label pour les informations du jeu.
     */
    public JLabel getLabInfo() {
        return labInfo;
    }

    /**
     * Retourne le label pour le temps restant.
     * @return Le label pour le temps restant.
     */
    public JLabel getLabTempsRestant() {
        return labTempsRestant;
    }

    /**
     * Retourne le bouton pour démarrer le jeu.
     * @return Le bouton pour démarrer le jeu.
     */
    public JButton getBtnJouer() {
        return btnJouer;
    }

    /**
     * Retourne la case à cocher pour le mode difficile.
     * @return La case à cocher pour le mode difficile.
     */
    public JCheckBox getCbxModeDifficile() {
        return cbxModeDifficile;
    }

    /**
     * Méthode appelée lorsqu'une souris est déplacée avec son bouton enfoncé.
     * @param e Événement de souris.
     */
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    /**
     * Méthode appelée lorsqu'une souris est déplacée.
     * @param e Événement de souris.
     */
    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
