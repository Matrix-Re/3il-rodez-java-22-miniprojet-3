package fr.ecole3il.rodez2023.pendu.view;

import fr.ecole3il.rodez2023.pendu.model.PenduModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PenduVue extends JFrame implements MouseMotionListener {

    private PenduModel Dm;
    private JFrame fen = this;
    private JLabel labLettresSaisies;
    private JLabel labMotATrouver;
    private JLabel labDeffinition;
    private JLabel labInfo;
    private JLabel labTempsRestant;
    private JButton btnJouer;
    private JCheckBox cbxModeDifficile;

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

    public JLabel getLabelLettreSaisies() {
        return labLettresSaisies;
    }

    public JLabel getLabelMotATrouver() {
        return labMotATrouver;
    }

    public JLabel getLabDeffinition() {
        return labDeffinition;
    }

    public JLabel getLabInfo() {
        return labInfo;
    }

    public JLabel getLabTempsRestant() {
        return labTempsRestant;
    }

    public JButton getBtnJouer() {
        return btnJouer;
    }

    public JCheckBox getCbxModeDifficile() {
        return cbxModeDifficile;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
