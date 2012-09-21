
package info.repartie;

import client.Client;
import client.clientSelector;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Port;

/**
 *
 * @author xtalandier
 */
public class InfoRepartie {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		/*
		SVGWriter svg = new SVGWriter("d:\\monsvg.svg");
		for(int i = 1 ; i < 11 ; i++){
			svg.dessinerProcessus(i, "Process #" + i);
			svg.dessinerSC(3, 0, 10);
			svg.dessinerREQ(3, 5, 10, 15);
			svg.dessinerREP(5, 1, 15, 30);
			svg.dessinerREAL(1, 6, 30, 35);
		}
		try {
			svg.close();
		} catch (IOException ex) {
			Logger.getLogger(InfoRepartie.class.getName()).log(Level.SEVERE, null, ex);
		}
		clientSelector cs = new clientSelector();
		cs.setVisible(true);
		*/
		Thread fils1 = new Thread(new Client("127.0.0.1" , 1234));
		fils1.start();

		Server srv = new Server();
		srv.run();
		
	}
}
