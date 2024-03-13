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

    private Mot mot;
    private Mot motCache;
    private int nbEssais = 0;

    private boolean jeuFini = false;

    List<Character> lettresSaisies = new ArrayList<Character>();
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
            motCache = new Mot("_".repeat(word.length()), definition);
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
    }

    public void ajouterLettreSaisie(char lettre){
        lettresSaisies.add(Character.toUpperCase(lettre));
    }

    public void lettreTrouvee(char lettre){
        StringBuilder motCacheBuilder = new StringBuilder(motCache.getMot());
        for (int i = 0; i < mot.getMot().length(); i++) {
            if (mot.getMot().charAt(i) == lettre) {
                motCacheBuilder.setCharAt(i, lettre);
            }
        }
        motCache.setMot(motCacheBuilder.toString());
    }

    public Mot getMot(){
        return mot;
    }

    public Mot getMotCache(){
        return motCache;
    }

    public String getLettresSaisies() {
        return lettresSaisies.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" - "));
    }

    public void videLettresSaisies() {
        lettresSaisies.clear();
    }

    public boolean isMotPresent(char mot) {
        return lettresSaisies.contains(Character.toUpperCase(mot));
    }

    public int getNbEssais() {
        return nbEssais;
    }

    public void incrementNbEssais() {
        this.nbEssais++;
    }

    public void resetNbEssais() {
        this.nbEssais = 0;
    }

    public boolean isJeuFini() {
        return jeuFini;
    }

    public void setJeuFini(boolean jeuFini) {
        this.jeuFini = jeuFini;
    }

}