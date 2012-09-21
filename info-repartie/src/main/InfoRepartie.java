
package main;

import client.Program1;
import server.Program2;
/**
 *
 * @author xtalandier
 */
public class InfoRepartie {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Thread prog1 = new Thread(new Program1());
		prog1.start();

		Thread prog2 = new Thread(new Program2());
		prog2.start();
	}
}
