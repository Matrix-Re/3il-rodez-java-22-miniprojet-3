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
    JPanel panel;

    public PenduVue(PenduModel Dm){
        this.Dm = Dm;
        panel = new JPanel();
        labLettresSaisies = new JLabel();
        labMotATrouver = new JLabel();
        labDeffinition = new JLabel();

        panel.setPreferredSize(new Dimension(300, 200));
        panel.setBackground(Color.blue);

        fen.setTitle("Pendu");
        fen.setLayout(new GridLayout(2, 1));
        fen.setBackground(Color.white);
        fen.setSize(400, 300);
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fen.setVisible(true);

        fen.add(panel);
        fen.add(labLettresSaisies);
        fen.add(labMotATrouver);
        fen.add(labDeffinition);

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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
