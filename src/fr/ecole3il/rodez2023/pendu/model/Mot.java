package fr.ecole3il.rodez2023.pendu.model;

public class Mot {
    private String mot;
    private String definition;

    Mot(String mot, String definition){
        this.mot = mot;
        this.definition = definition;
    }

    public String getMot(){
        return mot;
    }

    public String getDefinition(){
        return definition;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }
}
