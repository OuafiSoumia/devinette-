package Serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Client.Statistiques;

public interface IJeuRemote extends Remote {
	public String jouer(int nbr) throws RemoteException;
	public Statistiques obtenirStatistiques() throws RemoteException;
	public int obtenirNombreEssais() throws RemoteException;
	void nouvellePartie() throws RemoteException;
	boolean isFin()  throws RemoteException;
}
