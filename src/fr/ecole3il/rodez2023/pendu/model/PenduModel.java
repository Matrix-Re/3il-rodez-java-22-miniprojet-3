package fr.ecole3il.rodez2023.pendu.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class PenduModel {

    Mot mot;
    public String fichier = System.getProperty("user.dir") + "/data/mots.txt";

    public void genererMot(){
        try {
            Path path = Paths.get(fichier);
            List<String> lines = Files.readAllLines(path);
            int randomLineIndex = new Random().nextInt(lines.size());
            String line = lines.get(randomLineIndex);
            String[] parts = line.split(" ", 2);
            String word = parts[0];
            String definition = parts.length > 1 ? parts[1] : "";
            mot = new Mot(word, definition);
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
    }

    public Mot getMot(){
        return mot;
    }
}
