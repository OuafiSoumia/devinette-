package Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import Serveur.IJeuRemote;
import Serveur.JeuImpl;

public class ClientJeu {
	private Registry registry;
	private IJeuRemote remoteObj;
	
	public ClientJeu(Registry registry,IJeuRemote remoteObj){
		this.registry=registry;
		this.remoteObj=remoteObj;
	}
	
	//pour commancer le jeu
	public void jouer() throws RemoteException {
        System.out.println("Bienvenue dans le jeu de devinette !");
        System.out.println("Devinez le nombre secret (entre 1 et 100).");
		Scanner input=new Scanner(System.in);
		remoteObj.nouvellePartie();
		while(!remoteObj.isFin()) {
			System.out.println("Deviner: ");
			int nbr=input.nextInt();
			String rep=remoteObj.jouer(nbr);
			System.out.println(rep);
		}
	}
	

	public void statistique() throws RemoteException {
		 // Obtenir les statistiques
        Statistiques statistiques = remoteObj.obtenirStatistiques();

        // Exemple d'utilisation des statistiques
        int partiesJouees = statistiques.obtenirNombrePartiesJouees();
        int victoires = statistiques.obtenirNombreVictoires();

        System.out.println("Statistiques de jeu :");
        System.out.println("Nombre total de parties jouées : " + partiesJouees);
        System.out.println("Nombre de victoires : " + victoires);
	}
}
