
package main;

import client.Program1;
import client.Tampon;
import server.Program2;
/**
 *
 * @author xtalandier
 */
public class InfoRepartie {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread client = new Thread(new Program1());
		client.start();

		Thread serveur = new Thread(new Program2());
		serveur.start();
		
	}
}
