package fr.ecole3il.rodez2023.pendu.view;

import fr.ecole3il.rodez2023.pendu.model.PenduModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PenduVue extends JFrame implements MouseMotionListener {

    PenduModel Dm;
    JFrame fen = this;
    JLabel labLettresSaisies;
    JLabel labMotATrouver;
    JLabel labDeffinition;
    JLabel labInfo;
    JButton btnRejouer;

    public PenduVue(PenduModel Dm){
        this.Dm = Dm;
        labLettresSaisies = new JLabel();
        labMotATrouver = new JLabel();
        labDeffinition = new JLabel();
        labInfo = new JLabel();
        btnRejouer = new JButton("Rejouer");

        btnRejouer.setVisible(false);

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
        fen.add(btnRejouer);

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

    public JButton getBtnRejouer() {
        return btnRejouer;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
