package fr.ecole3il.rodez2023.pendu.tests;

import fr.ecole3il.rodez2023.pendu.model.Mot;
import fr.ecole3il.rodez2023.pendu.model.PenduModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class PenduModelTest {

    private PenduModel penduModel;

    @BeforeEach
    public void setup() {
        penduModel = new PenduModel();
    }

    @Test
    public void genererMot_generatesValidMot() {
        penduModel.genererMot();
        Mot mot = penduModel.getMot();
        assertNotNull(mot);
        assertNotNull(mot.getMot());
        assertNotNull(mot.getDefinition());
    }

}