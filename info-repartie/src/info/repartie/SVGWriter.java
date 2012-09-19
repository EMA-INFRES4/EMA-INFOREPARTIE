/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.repartie;

/**
 *
 * @author Cyril
 */
public class SVGWriter {
	
	private void appendToBody(String aa){
		
	}
	
	/**
	 * Draw arrow to canvas
	 * @param x1 Start position (x)
	 * @param y1 Start position (y)
	 * @param x2 End position (x)
	 * @param y2 End position (y)
	 * @param couleur Color
	 */
	public void tracerFleche(int x1 , int y1 , int x2 , int y2 , String couleur){
		this.appendToBody("<path d=\"M " + x1 + " " + y1 + " L " + x2 + " " + y2 + "\" style=\"fill:none;stroke:" + couleur + "; stroke-width:2; marker-end:url(#Triangle)\" />");
	}
	
	/**
	 * Write text to canvas
	 * @param x pos X
	 * @param y pos Y
	 * @param texte Text to write
	 * @param couleur Color
	 */
	public void ecrireText(int x, int y, String texte , String couleur){
		this.appendToBody("<text x=\"" + x + "\" y=\"" + y +"\"></text>");
	}
	
	/**
	 * Draw process
	 * @param num PID
	 * @param nom Name
	 */
	public void dessinerProcessus(int num , String nom){
		// TODO: Implement code
	}
	
	/**
	 * Draw red rectangle for critical section of process
	 * @param num
	 * @param dateDeb
	 * @param dateFin 
	 */
	public void dessinerSC (int num, int dateDeb, int dateFin){
		// TODO: Implement code
	}
}
