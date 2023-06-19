package Serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

import Client.Statistiques;

public class JeuImpl extends UnicastRemoteObject implements IJeuRemote {
    private int nbrDeviner;
    private boolean fin;
    private int nombreEssais;
    private Statistiques statistiques;
    private Random random ;



	@Override
    public boolean isFin() {
		return fin;
	}


	public void setFin(boolean fin) {
		this.fin = fin;
	}


	public JeuImpl() throws RemoteException {
    	super();
        statistiques = new Statistiques();
     //   nouvellePartie();
    }
    

	@Override
    public void nouvellePartie() throws RemoteException {
        random = new Random();
        // Pour générer le nombre à deviner
        nbrDeviner = random.nextInt(100) + 1;
        nombreEssais = 0;
        fin = false;
        System.out.println("le nbr a deviner est "+nbrDeviner);
       
    }
    
    // Pour jouer tant que le nombre secret n'est pas encore deviné, on va fournir à l'utilisateur des indications
    @Override
    public String jouer(int nbr) throws RemoteException {
        nombreEssais++;
        // Si le jeu n'est pas terminé
        System.out.println("le nbr a deviner jouer est "+nbrDeviner);
        if (!fin) {
            if (nbr > nbrDeviner) {
                return "Choisissez un autre nombre plus petit";
            } else if (nbr < nbrDeviner) {
                return "Choisissez un autre nombre plus grand";
            } else {
                fin = true;
                statistiques.incrementerPartiesJouees();
                statistiques.incrementerVictoires();
                return "Félicitations ! Vous avez deviné le nombre secret en " + obtenirNombreEssais() + " essais.";
            }
        } else {
            return "Le jeu est terminé, le nombre secret était " + nbrDeviner;
        }
    }
    
    @Override
    public int obtenirNombreEssais() throws RemoteException {
        return nombreEssais;
    }
    
    @Override
    public Statistiques obtenirStatistiques() throws RemoteException {
        return statistiques;
    }
}
