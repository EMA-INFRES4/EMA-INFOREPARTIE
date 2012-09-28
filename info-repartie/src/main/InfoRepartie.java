
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
		Message msg1 = new Message("Coucou", 54);
		String srz = msg1.toString();
		Message msg2 = Message.fromString(srz);
		System.out.println(msg2.toString());
//		Thread client = new Thread(new Program1());
//		client.start();
//
//		Thread serveur = new Thread(new Program2());
//		serveur.start();
		
	}
}
