package Serveur;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServeurRMI {
	public static void main(String[] args) {
			
			try {
				LocateRegistry.createRegistry(1099);
				JeuImpl od;
				od = new JeuImpl();
				System.out.println(od.toString());
				Naming.rebind("rmi://localhost:1099/Jeu", od);
	            System.out.println("Serveur RMI prêt !");

			} catch (RemoteException | MalformedURLException e1) {
				e1.printStackTrace();
			}
			
		
	}

}
