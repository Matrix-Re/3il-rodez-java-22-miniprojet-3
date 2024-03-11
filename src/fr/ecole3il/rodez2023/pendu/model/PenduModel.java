package fr.ecole3il.rodez2023.pendu.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PenduModel {

    Mot mot;

    List<Character> motsSaisies = new ArrayList<Character>();
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

    public void ajouterMotSaisies(char mot){
        motsSaisies.add(Character.toUpperCase(mot));
    }

    public String getMotsSaisies() {
        return motsSaisies.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" - "));
    }

    public boolean isMotPresent(char mot) {
        return motsSaisies.contains(Character.toUpperCase(mot));
    }

}