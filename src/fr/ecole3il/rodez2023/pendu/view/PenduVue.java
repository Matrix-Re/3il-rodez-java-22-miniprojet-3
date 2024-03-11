package fr.ecole3il.rodez2023.pendu.view;

import fr.ecole3il.rodez2023.pendu.model.PenduModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PenduVue extends JFrame implements MouseMotionListener {

    PenduModel Dm;
    JFrame fen = this;
    JLabel label;
    JPanel panel;

    public PenduVue(PenduModel Dm){
        this.Dm = Dm;
        panel = new JPanel();
        label = new JLabel("A - B - E - Z");

        panel.setPreferredSize(new Dimension(300, 200));
        panel.setBackground(Color.blue);

        fen.setTitle("Pendu");
        fen.setLayout(new GridLayout(2, 1));
        fen.setBackground(Color.white);
        fen.setSize(400, 300);
        fen.setVisible(true);

        fen.add(panel);
        fen.add(label);

        addMouseMotionListener(this);
    }

    public JLabel getLabel() {
        return label;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
