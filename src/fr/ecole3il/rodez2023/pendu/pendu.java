package fr.ecole3il.rodez2023.pendu;

import fr.ecole3il.rodez2023.pendu.controller.PenduController;
import fr.ecole3il.rodez2023.pendu.model.PenduModel;
import fr.ecole3il.rodez2023.pendu.view.PenduVue;

import javax.swing.*;
import java.awt.*;

public class pendu {
    public static void main(String[] args) {

        JFrame fen;
        fen = new JFrame("Dessin");
        fen.setBackground(Color.white);
        fen.setSize(400, 300);

        PenduModel Dm = new PenduModel();
        PenduVue Dv = new PenduVue(Dm);
        JButton button = new JButton();

        PenduController Dc = new PenduController(Dm, Dv, button);

        fen.add(Dv);
        fen.setVisible(true);

    }
}
