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
public class tamponReception {
	private ArrayList<String> buffer;
	private int bufferSize;
	
	/**
	 * Constructor
	 * @param size Buffer Size
	 */
	public tamponReception(int size){
		this.buffer = new ArrayList<String>();
		this.bufferSize=size;
	}
	
	/**
	 * Pull buffer infos
	 */
	public synchronized String pullInBuffer() throws InterruptedException{
		if(buffer.isEmpty()){
			wait();
			return null;
		}
		else {
			String returnValue =  buffer.get(0);
			buffer.remove(0);
			notifyAll();
			return returnValue;
		}
	}
	
	/**
	 * Push buffer infos
	 * @param infoValue Info to add in the buffer
	 */
	public synchronized void pushInBuffer(String infoValue) throws InterruptedException{
		if(buffer.size()==bufferSize){
			wait();
		}
		else {
			buffer.add(infoValue);
			notifyAll();
		}
	}
}
