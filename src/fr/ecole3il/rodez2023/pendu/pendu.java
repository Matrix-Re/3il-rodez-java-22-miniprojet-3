package fr.ecole3il.rodez2023.pendu;

import fr.ecole3il.rodez2023.pendu.controller.PenduController;
import fr.ecole3il.rodez2023.pendu.model.PenduModel;
import fr.ecole3il.rodez2023.pendu.view.PenduVue;

import javax.swing.*;
import java.awt.*;

public class pendu {
    public static void main(String[] args) {
        try {
            PenduModel Dm = new PenduModel();
            PenduVue Dv = new PenduVue(Dm);

            PenduController Dc = new PenduController(Dm, Dv);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
