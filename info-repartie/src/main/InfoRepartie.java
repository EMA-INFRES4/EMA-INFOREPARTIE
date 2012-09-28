
package main;

import client.Program1;
import client.Tampon;
import common.Message;
import server.Program2;
import server.SVGWriter;
/**
 *
 * @author xtalandier
 */
public class InfoRepartie {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws InterruptedException {
		// Start client
		Thread client = new Thread(new Program1());
		client.start();
		
		// Start server
		Thread serveur = new Thread(new Program2());
		serveur.start();
		
	}
}
