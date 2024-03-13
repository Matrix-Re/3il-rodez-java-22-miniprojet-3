package fr.ecole3il.rodez2023.pendu.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Classe PenduModel qui représente le modèle du jeu du pendu.
 */
public class PenduModel {

    /**
     * Le mot à deviner dans le jeu.
     */
    private Mot mot;

    /**
     * Le mot caché qui est affiché aux joueurs.
     */
    private Mot motCache;

    /**
     * Le nombre d'essais effectués par le joueur.
     */
    private int nbEssais = 0;

    /**
     * Indique si le jeu est terminé ou non.
     */
    private boolean jeuFini = true;

    /**
     * Liste des lettres qui ont été proposées par le joueur.
     */
    List<Character> lettresSaisies = new ArrayList<Character>();

    /**
     * Le chemin du fichier contenant les mots à deviner.
     */
    public String fichier = System.getProperty("user.dir") + "/data/mots.txt";


    /**
     * Génère un nouveau mot à deviner pour le jeu.
     */
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

    /**
     * Ajoute une lettre à la liste des lettres proposées par le joueur.
     * @param lettre La lettre à ajouter.
     */
    public void ajouterLettreSaisie(char lettre){
        lettresSaisies.add(Character.toUpperCase(lettre));
    }

    /**
     * Met à jour le mot caché lorsque le joueur a trouvé une lettre.
     * @param lettre La lettre trouvée.
     */
    public void lettreTrouvee(char lettre){
        StringBuilder motCacheBuilder = new StringBuilder(motCache.getMot());
        for (int i = 0; i < mot.getMot().length(); i++) {
            if (mot.getMot().charAt(i) == lettre) {
                motCacheBuilder.setCharAt(i, lettre);
            }
        }
        motCache.setMot(motCacheBuilder.toString());
    }

    /**
     * Retourne le mot à deviner.
     * @return Le mot à deviner.
     */
    public Mot getMot(){
        return mot;
    }

    /**
     * Retourne le mot caché.
     * @return Le mot caché.
     */
    public Mot getMotCache(){
        return motCache;
    }

    /**
     * Retourne les lettres qui ont été proposées par le joueur.
     * @return Les lettres proposées.
     */
    public String getLettresSaisies() {
        return lettresSaisies.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" - "));
    }

    /**
     * Vide la liste des lettres proposées par le joueur.
     */
    public void videLettresSaisies() {
        lettresSaisies.clear();
    }

    /**
     * Vérifie si une lettre a déjà été proposée par le joueur.
     * @param mot La lettre à vérifier.
     * @return Vrai si la lettre a déjà été proposée, faux sinon.
     */
    public boolean isMotPresent(char mot) {
        return lettresSaisies.contains(Character.toUpperCase(mot));
    }

    /**
     * Retourne le nombre d'essais effectués par le joueur.
     * @return Le nombre d'essais.
     */
    public int getNbEssais() {
        return nbEssais;
    }

    /**
     * Incrémente le nombre d'essais effectués par le joueur.
     */
    public void incrementNbEssais() {
        this.nbEssais++;
    }

    /**
     * Réinitialise le nombre d'essais effectués par le joueur.
     */
    public void resetNbEssais() {
        this.nbEssais = 0;
    }

    /**
     * Indique si le jeu est terminé ou non.
     * @return Vrai si le jeu est terminé, faux sinon.
     */
    public boolean isJeuFini() {
        return jeuFini;
    }

    /**
     * Définit si le jeu est terminé ou non.
     * @param jeuFini Vrai si le jeu est terminé, faux sinon.
     */
    public void setJeuFini(boolean jeuFini) {
        this.jeuFini = jeuFini;
    }

}