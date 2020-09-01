/**
 * 
 */
package app;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import interfaces.Events;

/**
 * EventHandler stores the event listeners as well as notifies them when a event occurs.
 * @author Laffini
 *
 */
public class EventHandler {

	private ArrayList<Events> listeners = new ArrayList<Events>();

	public EventHandler(ArrayList<Events> listeners) {
		this.listeners=listeners;
	} 

	public void notifyOnScreenshot(BufferedImage screenshot) {
		for (int i = 0 ; i<listeners.size();i++) {
			listeners.get(i).onScreenshot(screenshot);
		}

	}

	/**
	 * @return the listeners
	 */
	public ArrayList<Events> getListeners() {
		return listeners;
	}

	/**
	 * @param listeners the listeners to set
	 */
	public void setListeners(ArrayList<Events> listeners) {
		this.listeners = listeners;
	}



}
