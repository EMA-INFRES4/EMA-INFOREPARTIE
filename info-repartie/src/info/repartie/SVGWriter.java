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
	private String header;
	private String body;
	private String footer;
	private String _fileName;
	
	/**
	 * Add data to body
	 * @param data  data to add
	 */
	private void appendToBody(String data){
		this.body += data;
	}
	
	/**
	 * SVGWriter Constructor
	 * @param fileName file path to modify
	 */
	public SVGWriter(String fileName){
		this.header = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
				+ "<svg xmlns=\"http://www.w3.org/2000/svg\"  height=\"500\" width=\"500\">"
				+ "<defs>"
				+ "<marker"
				+ "id=\"Triangle\" viewBox=\"0 0 40 40\" refX=\"16\""
				+ "refY=\"16\" markerWidth=\"10\" markerHeight=\"10\" orient=\"auto\">"
				+ "</marker>"
				+ "</defs>";
		
		this.footer = "</svg>";
	}
	
	/**
	 * Permit to draw a line
	 * @param x1 start position (x)
	 * @param y1 start position (y)
	 * @param x2 final position (x)
	 * @param y2 final position (y)
	 * @param couleur line color
	 */
	public void tracerTrait (int x1, int y1, int x2, int y2, String couleur){
		this.appendToBody("<line x1=\"" + x1 + "\" y1=\"" + y1 + "\" x2=\""+ x2 + "\" y2=\"" + y2 + "\" stroke=\"" + couleur + "\" />");
	}
	
	/**
	 * Permit to draw a rectangle	
	 * @param x start position (x)
	 * @param y start position (x)
	 * @param largeur rect largeur
	 * @param longueur rect longueur
	 * @param couleur rect color
	 */
	public void tracerRectangle (int x, int y, int largeur, int longueur, String couleur){
		this.appendToBody(" <rect width=\"" + x + "\" height=\"" + y + "\" x=\"" + largeur + "\" y=\"" + longueur + "\" fill=\"" + couleur + "\" />");
	}
}
