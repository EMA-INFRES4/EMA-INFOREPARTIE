
package info.repartie;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xtalandier
 */
public class InfoRepartie {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
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
		
	}
}
