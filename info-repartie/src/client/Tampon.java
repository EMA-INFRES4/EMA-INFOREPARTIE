/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.ArrayList;

/**
 *
 * @author Cyril
 */
public class Tampon {
	private ArrayList<String> buffer;
	private int bufferSize;
	
	/**
	 * Constructor
	 * @param size Buffer Size
	 */
	public Tampon(int size){
		this.bufferSize=size;
	}
	
	/**
	 * Pull buffer infos
	 */
	synchronized String pullInBuffer() throws InterruptedException{
		if(buffer.isEmpty()){
			wait();
			return null;
		}
		else {
			String returnValue =  buffer.get(buffer.size()-1);
			buffer.remove(returnValue);
			notifyAll();
			return returnValue;
		}
	}
	
	/**
	 * Push buffer infos
	 * @param infoValue Info to add in the buffer
	 */
	synchronized void pushInBuffer(String infoValue) throws InterruptedException{
		if(buffer.size()==bufferSize){
			wait();
		}
		else {
			buffer.add(infoValue);
			notifyAll();
		}
	}
}
