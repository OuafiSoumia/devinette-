package Client;

import java.io.Serializable;

public class Statistiques implements Serializable {
    private int nombrePartiesJouees;
    private int nombreVictoires;

    public Statistiques() {
        nombrePartiesJouees = 0;
        nombreVictoires = 0;
    }

    public void incrementerPartiesJouees() {
        nombrePartiesJouees++;
    }

    public void incrementerVictoires() {
        nombreVictoires++;
    }

    public int obtenirNombrePartiesJouees() {
        return nombrePartiesJouees;
    }

    public int obtenirNombreVictoires() {
        return nombreVictoires;
    }
}
