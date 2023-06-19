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
public class Client2Main {

		public static void main(String[] args) throws RemoteException, NotBoundException {
			  // Obtient le registre RMI
	        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
	        // Récupère le stub de l'objet distant
	        IJeuRemote remoteObj = (IJeuRemote) registry.lookup("Jeu");
	        ClientJeu client1=new ClientJeu(registry,remoteObj);
	        client1.jouer();
			client1.statistique();
			
		     System.out.println("--------------------------------------------------------------------");		
		     System.out.println("Si vous vouLez rejouer taper:0");
		     System.out.println("Si vous voulez quité le jeu taper:-1");

				Scanner input=new Scanner(System.in);
				int choix=input.nextInt();
				while(choix!=-1) {
					
					if(choix==0) {
					  System.out.println("rejouer");

				       client1.jouer();
						client1.statistique();
				}
				     System.out.println("--------------------------------------------------------------------");		
				     System.out.println("Si vous vouLez rejouer taper:0");
				     System.out.println("Si vous voulez quité le jeu taper:-1");
					choix=input.nextInt();
				}
				client1.statistique();


	}

}
