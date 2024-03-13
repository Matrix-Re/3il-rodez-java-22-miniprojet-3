package fr.ecole3il.rodez2023.pendu.view;

import fr.ecole3il.rodez2023.pendu.model.Mot;
import fr.ecole3il.rodez2023.pendu.model.PenduModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PenduVue extends JFrame implements MouseMotionListener {

    PenduModel Dm;
    JFrame fen = this;
    JLabel labMotSaisies;
    JLabel labMotATrouver;
    JPanel panel;

    public PenduVue(PenduModel Dm){
        this.Dm = Dm;
        panel = new JPanel();
        labMotSaisies = new JLabel();
        labMotATrouver = new JLabel();

        panel.setPreferredSize(new Dimension(300, 200));
        panel.setBackground(Color.blue);

        fen.setTitle("Pendu");
        fen.setLayout(new GridLayout(2, 1));
        fen.setBackground(Color.white);
        fen.setSize(400, 300);
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fen.setVisible(true);

        fen.add(panel);
        fen.add(labMotSaisies);
        fen.add(labMotATrouver);

        addMouseMotionListener(this);
    }

    public JLabel getLabel() {
        return labMotSaisies;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
